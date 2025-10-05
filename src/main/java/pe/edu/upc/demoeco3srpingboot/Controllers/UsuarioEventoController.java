package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioEventoDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Evento;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioEvento;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioEventoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario-evento")
public class UsuarioEventoController {

    @Autowired
    private IUsuarioEventoService ueS;

    // INSERTAR
    @PostMapping
    @PreAuthorize("hasAuthority('CLIENT')")
    public String insert(@RequestBody UsuarioEventoDTO dto) {
        UsuarioEvento h = new UsuarioEvento();
        h.setIdUsuarioEvento(dto.getIdUsuarioEvento());

        Usuario u = new Usuario();
        u.setIdUsuario(dto.getUsuarioId());
        h.setUsuario(u);

        Evento e = new Evento();
        e.setIdEvento(dto.getEventoId());
        h.setEvento(e);

        h.setFechaRegistro(dto.getFechaRegistro());

        ueS.insert(h);
        return "Inscripcion a evento registrada correctamente";
    }

    // ACTUALIZAR
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioEventoDTO dto) {
        UsuarioEvento re = new UsuarioEvento();
        re.setIdUsuarioEvento(dto.getIdUsuarioEvento());

        Usuario u = new Usuario();
        u.setIdUsuario(dto.getUsuarioId());
        re.setUsuario(u);

        Evento e = new Evento();
        e.setIdEvento(dto.getEventoId());
        re.setEvento(e);

        re.setFechaRegistro(dto.getFechaRegistro());

        UsuarioEvento existente = ueS.listId(re.getIdUsuarioEvento());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario evento con el ID: " + re.getIdUsuarioEvento());
        }
        ueS.update(re);
        return ResponseEntity.ok("Usuario evento con ID " + re.getIdUsuarioEvento() + " modificado correctamente.");
    }

    // ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        UsuarioEvento t = ueS.listId(id);
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario evento con el ID: " + id);
        }
        ueS.delete(id);
        return ResponseEntity.ok("Usuario evento con ID " + id + " eliminado correctamente.");
    }

    // LISTAR
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<UsuarioEventoDTO> listar() {
        return ueS.list().stream().map(entity -> {
            UsuarioEventoDTO dto = new UsuarioEventoDTO();
            dto.setIdUsuarioEvento(entity.getIdUsuarioEvento());
            dto.setUsuarioId(entity.getUsuario().getIdUsuario());
            dto.setEventoId(entity.getEvento().getIdEvento());
            dto.setFechaRegistro(entity.getFechaRegistro());
            return dto;
        }).collect(Collectors.toList());
    }

    // TOTAL EVENTOS POR FECHA
    @GetMapping("/totalEventos")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> getTotalEventos(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        long total = ueS.contarEventosEnRango(fechaInicio, fechaFin);

        if (total == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron eventos en el rango de fechas proporcionado ("
                            + fechaInicio + " a " + fechaFin + ")");
        }

        return ResponseEntity.ok("Total de eventos encontrados entre "
                + fechaInicio + " y " + fechaFin + ": " + total);
    }
}

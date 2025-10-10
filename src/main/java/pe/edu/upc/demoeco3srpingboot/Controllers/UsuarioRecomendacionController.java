package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioRecomendacionDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Recomendacion;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecomendacion;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario-recomendacion")
public class UsuarioRecomendacionController {

    @Autowired
    private IUsuarioRecomendacionService urS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public void insert(@RequestBody UsuarioRecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioRecomendacion uh =m.map(dto,UsuarioRecomendacion.class);
        urS.insert(uh);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<UsuarioRecomendacionDTO> list(){
        return urS.list().stream().map(x -> {
            UsuarioRecomendacionDTO dto = new UsuarioRecomendacionDTO();
            dto.setIdUsuarioRecomendacion(x.getIdUsuarioRecomendacion());
            dto.setIdUsuario(x.getUsuario().getIdUsuario());
            dto.setIdRecomendacion(x.getRecomendacion().getIdRecomendacion());
            dto.setFechaAsignacion(x.getFechaAsignacion());
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarRecomendacionesPorUsuario(@PathVariable("idUsuario") int idUsuario) {
        List<Recomendacion> recomendaciones = urS.findRecomendacionesPorUsuario(idUsuario);

        if (recomendaciones.isEmpty()) {
            return ResponseEntity.ok("No tienes recomendaciones asignadas");
        }

        return ResponseEntity.ok(recomendaciones);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioRecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioRecomendacion re = m.map(dto, UsuarioRecomendacion.class);

        UsuarioRecomendacion existente = urS.listId(re.getIdUsuarioRecomendacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reserva con el ID: " + re.getIdUsuarioRecomendacion());
        }
        urS.update(re);
        return ResponseEntity.ok("Reserva con ID " + re.getIdUsuarioRecomendacion() + " modificado correctamente.");
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        UsuarioRecomendacion t = urS.listId(id);
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        urS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/filtrar")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> filtrarPorTipo(@RequestParam("tipo") String tipo) {
        List<Recomendacion> resultados = urS.filtrarPorTipo(tipo);

        if (resultados.isEmpty()) {
            return ResponseEntity.ok("No se encontraron recomendaciones con ese filtro");
        }

        return ResponseEntity.ok(resultados);
    }

}

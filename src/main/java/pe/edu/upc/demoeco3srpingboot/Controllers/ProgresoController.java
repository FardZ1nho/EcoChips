package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.ProgresoDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.ProgresoResultadoDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.ResumenDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;
import pe.edu.upc.demoeco3srpingboot.Entities.Progreso;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.IActividadRepository;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUserRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IProgresoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/progresos")
public class ProgresoController {

    @Autowired
    private IProgresoService progresoService;

    @Autowired
    private IUserRepository usuarioRepo;

    @Autowired
    private IActividadRepository actividadRepo;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<ProgresoDTO> listar() {
        return progresoService.list().stream().map(progreso -> {
            ModelMapper m = new ModelMapper();
            return m.map(progreso, ProgresoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CLIENT')")
    public ResponseEntity<String> insertar(@RequestBody ProgresoDTO dto) {
        Progreso progreso = new Progreso();
        progreso.setFecha(dto.getFecha());
        progreso.setPuntos(dto.getPuntos());
        progreso.setEstado(dto.isEstado());

        Usuario usuario = usuarioRepo.findById(dto.getIdUsuario()).orElse(null);
        Actividad actividad = actividadRepo.findById(dto.getIdActividad()).orElse(null);

        if (usuario == null || actividad == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuario o actividad no encontrados");
        }

        progreso.setUsuario(usuario);
        progreso.setActividad(actividad);

        progresoService.insert(progreso);
        return ResponseEntity.ok("Registrado correctamente");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarPorId(@PathVariable int id) {
        Progreso progreso = progresoService.listId(id);
        if (progreso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un progreso con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ProgresoDTO dto = m.map(progreso, ProgresoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody ProgresoDTO dto) {
        Progreso progreso = progresoService.listId(dto.getIdProgreso());
        if (progreso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dto.getIdProgreso());
        }

        progreso.setFecha(dto.getFecha());
        progreso.setPuntos(dto.getPuntos());
        progreso.setEstado(dto.isEstado());

        Usuario usuario = usuarioRepo.findById(dto.getIdUsuario()).orElse(null);
        Actividad actividad = actividadRepo.findById(dto.getIdActividad()).orElse(null);

        if (usuario == null || actividad == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuario o actividad no encontrados");
        }

        progreso.setUsuario(usuario);
        progreso.setActividad(actividad);

        progresoService.update(progreso);
        return ResponseEntity.ok("Registro con ID " + dto.getIdProgreso() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Progreso progreso = progresoService.listId(id);
        if (progreso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        progresoService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/resumen/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN')")
    public ResumenDTO resumen(@PathVariable int idUsuario) {
        return progresoService.obtenerResumen(idUsuario);
    }

    @PutMapping("/completar/{idProgreso}")
    public ResponseEntity<?> completarProgreso(@PathVariable int idProgreso) {
        Progreso progreso = progresoService.completarProgresoYAsignarCanje(idProgreso);
        if (progreso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un progreso con ID: " + idProgreso);
        }

        ProgresoResultadoDTO resultadoDTO = new ProgresoResultadoDTO();
        resultadoDTO.setIdUsuario(progreso.getUsuario().getIdUsuario());
        resultadoDTO.setNivel(progreso.getUsuario().getNivel());
        resultadoDTO.setCanjesDisponibles(progreso.getUsuario().getCanjesDisponibles());

        return ResponseEntity.ok(resultadoDTO);
    }
}

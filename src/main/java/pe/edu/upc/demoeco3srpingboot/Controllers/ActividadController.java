package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.ActividadDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IActividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividades")
public class ActividadController {
    @Autowired
    private IActividadService actividadService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<ActividadDTO> list(){
        return actividadService.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ActividadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public String insertar(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad a = m.map(dto, Actividad.class);

        actividadService.insert(a);
        return "Registrado correctamente";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Actividad dev = actividadService.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una actividad con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ActividadDTO dto = m.map(dev, ActividadDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad dev = m.map(dto, Actividad.class);

        Actividad existente = actividadService.listId(dev.getIdActividad());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + dev.getIdActividad());
        }

        actividadService.update(dev);
        return ResponseEntity.ok("Registro con ID " + dev.getIdActividad() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Actividad d = actividadService.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        actividadService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}


package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.NotificacionDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Notificacion;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;


    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<NotificacionDTO> list() {
        return nS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> insertar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.insert(n);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Notificación registrada correctamente");
    }

    //
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Notificacion dev = nS.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una notificación con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(dev, NotificacionDTO.class);
        return ResponseEntity.ok(dto);
    }



    @PutMapping("/{id}/desactivar")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<String> desactivar(@PathVariable("id") Integer id) {
        Notificacion n = nS.listId(id);
        if (n == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Notificación no encontrada");
        }

        n.setTipo("inactivo");
        nS.insert(n);

        return ResponseEntity.ok("Notificación desactivada correctamente");
    }


    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion re = m.map(dto, Notificacion.class);

        Notificacion existente = nS.listId(re.getIdNotificacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reserva con el ID: " + re.getIdNotificacion());
        }
        nS.update(re);
        return ResponseEntity.ok("Notificacion con ID " + re.getIdNotificacion() + " modificado correctamente.");
    }


    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Notificacion t = nS.listId(id);
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una notificacion con el ID: " + id);
        }
        nS.delete(id);
        return ResponseEntity.ok("Notifocacion con ID " + id + " eliminado correctamente.");
    }

}

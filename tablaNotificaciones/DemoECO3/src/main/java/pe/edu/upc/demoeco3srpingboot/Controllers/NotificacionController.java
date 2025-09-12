package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // Listar todas las notificaciones
    @GetMapping
    public List<NotificacionDTO> list() {
        return nS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    //  Insertar una notificación (aplica para logros, retos, alertas, etc.)
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.insert(n);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Notificación registrada correctamente");
    }

    //
    @GetMapping("/{id}")
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

    // US16 – Filtrar notificaciones de logros
    @GetMapping("/logros")
    public List<NotificacionDTO> listarLogros() {
        return nS.list().stream()
                .filter(n -> "logro".equalsIgnoreCase(n.getTipo()))
                .map(n -> new ModelMapper().map(n, NotificacionDTO.class))
                .collect(Collectors.toList());
    }

    // US17 – Filtrar notificaciones de retos
    @GetMapping("/retos")
    public List<NotificacionDTO> listarRetos() {
        return nS.list().stream()
                .filter(n -> "reto".equalsIgnoreCase(n.getTipo()))
                .map(n -> new ModelMapper().map(n, NotificacionDTO.class))
                .collect(Collectors.toList());
    }

    // US18 – Desactivar notificaciones de un hábito (requiere campo "activo")
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<String> desactivar(@PathVariable("id") Integer id) {
        Notificacion n = nS.listId(id);
        if (n == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Notificación no encontrada");
        }

        // 👇 Requiere que tu entidad y DTO tengan un campo boolean "activo"
        n.setActivo(false);
        nS.insert(n);

        return ResponseEntity.ok("Notificación desactivada correctamente");
    }

    // US19 – Configurar recordatorios de hábitos
    @PostMapping("/recordatorios")
    public ResponseEntity<String> configurarRecordatorio(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        n.setTipo("recordatorio");
        nS.insert(n);
        return ResponseEntity.ok("Recordatorio configurado correctamente");
    }

    // US20 – Alertas de impacto ambiental
    @GetMapping("/alertas")
    public List<NotificacionDTO> listarAlertas() {
        return nS.list().stream()
                .filter(n -> "alerta".equalsIgnoreCase(n.getTipo()))
                .map(n -> new ModelMapper().map(n, NotificacionDTO.class))
                .collect(Collectors.toList());
    }
}

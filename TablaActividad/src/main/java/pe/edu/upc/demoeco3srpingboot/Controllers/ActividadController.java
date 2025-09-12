package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private IActividadService aS;
    @GetMapping
    public List<ActividadDTO> list(){
        return aS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ActividadDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody ActividadDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Actividad a=m.map(dto,Actividad.class);
        aS.insert(a);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Actividad dev = aS.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una actividad con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ActividadDTO dto = m.map(dev, ActividadDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Actividad a = aS.listId(id);
        if (a == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        aS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad act = m.map(dto, Actividad.class);

        // Validación de existencia
        Actividad existente = aS.listId(act.getIdActividad());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + act.getIdActividad());
        }

        // Actualización si pasa validaciones
        aS.update(act);
        return ResponseEntity.ok("Registro con ID " + act.getIdActividad() + " modificado correctamente.");
    }
}

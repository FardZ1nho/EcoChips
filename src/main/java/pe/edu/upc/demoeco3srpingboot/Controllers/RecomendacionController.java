package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.RecomendacionDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Recomendacion;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendacion")
public class RecomendacionController {

    @Autowired
    private IRecomendacionService rS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<RecomendacionDTO> list(){
        return rS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public String insertar(@RequestBody RecomendacionDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Recomendacion a=m.map(dto,Recomendacion.class);
        rS.insert(a);
        return "Recomendacion registrada correctamente";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Recomendacion dev = rS.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una recomendacion con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecomendacionDTO dto = m.map(dev, RecomendacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recomendacion t = rS.listId(id);
        if (t == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }


    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody RecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendacion re = m.map(dto, Recomendacion.class);

        Recomendacion existente = rS.listId(re.getIdRecomendacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una reserva con el ID: " + re.getIdRecomendacion());
        }
        rS.update(re);
        return ResponseEntity.ok("Reserva con ID " + re.getIdRecomendacion() + " modificado correctamente.");
    }
}
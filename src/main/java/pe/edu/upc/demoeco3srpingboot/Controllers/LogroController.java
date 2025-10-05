package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.LogroDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Logro;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ILogroService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logros")
public class LogroController {
    @Autowired
    private ILogroService lService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String insertar(@RequestBody LogroDTO dto) {
        ModelMapper m = new ModelMapper();
        Logro l= m.map(dto, Logro.class);
        lService.insert(l);
        return "Logro registrado correctamente";
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<LogroDTO> listar(){
        return lService.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LogroDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> Delete(@PathVariable("id") Integer id) {
        Logro lo = lService.listId(id);
        if (lo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un Logro con el ID: " + id);
        }
        lService.delete(id);
        return ResponseEntity.ok("Logro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody LogroDTO dto) {
        ModelMapper m = new ModelMapper();
        Logro l = m.map(dto, Logro.class);
        Logro existente = lService.listId(l.getIdLogro());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + l.getIdLogro());
        }
        lService.update(l);
        return ResponseEntity.ok("Registro con ID " + l.getIdLogro() + " modificado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listaId(@PathVariable("id") Integer id) {
        Logro lo = lService.listId(id);
        if (lo == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una recompensa con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        LogroDTO dto = m.map(lo, LogroDTO.class);
        return ResponseEntity.ok(dto);
    }
}

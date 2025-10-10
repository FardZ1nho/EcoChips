package pe.edu.upc.demoeco3srpingboot.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.SoporteRespuestaDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.SoporteRespuestaListDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteRespuesta;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ISoporteRespuestaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/respuestas")
public class SoporteRespuestaController {

    @Autowired
    private ISoporteRespuestaService rS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<?> listar() {
        List<SoporteRespuestaListDTO> lista = rS.listarRespuestasReducidas();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public String insertar(@RequestBody SoporteRespuestaDTO dto) {
        ModelMapper m = new ModelMapper();
        SoporteRespuesta r = m.map(dto, SoporteRespuesta.class);
        rS.insert(r);
        return "Respuesta registrada correctamente";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        SoporteRespuesta r = rS.obtenerRespuestaPorId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una respuesta con el ID " + id);
        }
        ModelMapper m = new ModelMapper();
        SoporteRespuestaDTO dto = m.map(r, SoporteRespuestaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        SoporteRespuesta r = rS.obtenerRespuestaPorId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Registro con Id " + id + " eliminado correctamente");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody SoporteRespuestaDTO dto) {
        ModelMapper m = new ModelMapper();
        SoporteRespuesta r = m.map(dto, SoporteRespuesta.class);

        SoporteRespuesta existente = rS.obtenerRespuestaPorId(r.getIdRespuesta());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + r.getIdRespuesta());
        }

        rS.update(r);
        return ResponseEntity.ok("Registro con Id " + r.getIdRespuesta() + " modificado correctamente");
    }
}

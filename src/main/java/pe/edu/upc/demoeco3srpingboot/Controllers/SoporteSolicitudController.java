package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.SoporteSolicitudDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteSolicitud;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ISoporteSolicitudService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/soporte")
public class SoporteSolicitudController {
    @Autowired
    private ISoporteSolicitudService sR;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<SoporteSolicitudDTO> listar() {
        return sR.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,SoporteSolicitudDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CLIENT')")
    public String insertar(@RequestBody SoporteSolicitudDTO solicitud) {
        ModelMapper m = new ModelMapper();
        SoporteSolicitud so = m.map(solicitud, SoporteSolicitud.class);
        sR.insert(so);
        return "Solicitud registrada correctamente";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','SOPORTE','ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        SoporteSolicitud r = sR.listID(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una respuesta con el ID " + id);
        }
        ModelMapper m = new ModelMapper();
        SoporteSolicitudDTO dto = m.map(r, SoporteSolicitudDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SOPORTE','ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        SoporteSolicitud r = sR.listID(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID " + id);
        }
        sR.delete(id);
        return ResponseEntity.ok("Registro con Id " + id + " eliminado correctamente");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('SOPORTE','ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody SoporteSolicitudDTO dto) {
        ModelMapper m = new ModelMapper();
        SoporteSolicitud r = m.map(dto, SoporteSolicitud.class);

        SoporteSolicitud existente = sR.listID(r.getIdSoporteSolicitud());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID " + r.getIdSoporteSolicitud());
        }

        sR.update(r);
        return ResponseEntity.ok("Registro con Id " + r.getIdSoporteSolicitud() + " modificado correctamente");
    }

    @GetMapping("/buscar")
    @PreAuthorize("hasAnyAuthority('SOPORTE','ADMIN')")
    public List<SoporteSolicitudDTO> listarBuscar(@PathVariable("titulo") String titulo) {
        return sR.buscarSoporteSolicitud(titulo).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, SoporteSolicitudDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/estado")
    @PreAuthorize("hasAnyAuthority('SOPORTE','ADMIN')")
    public List<SoporteSolicitudDTO> listarPorEstado(@PathVariable("estado") String estado) {
        return sR.listarPorEstado(estado).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, SoporteSolicitudDTO.class);
        }).collect(Collectors.toList());
    }
}
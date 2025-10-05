package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.RecompensaDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRecompensaService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recompensas")
public class RecompensaController {

    @Autowired
    private IRecompensaService recompensaService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<RecompensaDTO> list() {
        return recompensaService.listar().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, RecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public String insertar(@RequestBody RecompensaDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensa r = m.map(dto, Recompensa.class);

        recompensaService.insertar(r);
        return "Recompensa registrada correctamente";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Recompensa dev = recompensaService.listarPorId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una recompensa con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecompensaDTO dto = m.map(dev, RecompensaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody RecompensaDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensa dev = m.map(dto, Recompensa.class);

        Recompensa existente = recompensaService.listarPorId(dev.getIdRecompensa());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una recompensa con el ID: " + dev.getIdRecompensa());
        }

        recompensaService.actualizar(dev);
        return ResponseEntity.ok("Recompensa con ID " + dev.getIdRecompensa() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recompensa d = recompensaService.listarPorId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una recompensa con el ID: " + id);
        }
        recompensaService.eliminar(id);
        return ResponseEntity.ok("Recompensa con ID " + id + " eliminada correctamente.");
    }

    @GetMapping("/buscar/menorIgual/{canjes}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<RecompensaDTO> buscarPorCostoMenorIgual(@PathVariable("canjes") int canjes) {
        return recompensaService.buscarPorCostoCanjesMenorIgual(canjes).stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscar/costo/{canjes}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<RecompensaDTO> buscarPorCosto(@PathVariable("canjes") int canjes) {
        return recompensaService.buscarPorCostoCanjes(canjes).stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscar/titulo/{titulo}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<RecompensaDTO> buscarPorTitulo(@PathVariable("titulo") String titulo) {
        return recompensaService.buscarPorTitulo(titulo).stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RecompensaDTO.class);
        }).collect(Collectors.toList());
    }
}
package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.HabitoEcologicoDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioHabitoDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioRecompensaDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioHabito;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioHabitoService;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecompensaService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/us-habito")
public class UsuarioHabitoController {
    @Autowired
    private IUsuarioHabitoService uhS;

    @PostMapping
    @PreAuthorize("hasAuthority('CLIENT')")
    public void insert(@RequestBody UsuarioHabitoDTO dto)
    {
        ModelMapper m = new ModelMapper();
        UsuarioHabito uh =m.map(dto,UsuarioHabito.class);
        uhS.insert(uh);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<UsuarioHabitoDTO> list(){
        return uhS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioHabitoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        UsuarioHabito uh = uhS.listId(id);
        if (uh == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioHabitoDTO dto = m.map(uh, UsuarioHabitoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioHabitoDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuarioHabito uh = m.map(dto, UsuarioHabito.class);

        UsuarioHabito existente = uhS.listId(uh.getIdUsuarioHabito());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + uh.getIdUsuarioHabito());
        }

        uhS.update(uh);
        return ResponseEntity.ok("Registro con ID " + uh.getIdUsuarioHabito() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        UsuarioHabito uh = uhS.listId(id);
        if (uh == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        uhS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");

    }

    @GetMapping("/habitoscumplidos")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<?> findHabitosCompletadosPorUsuario(@RequestParam("idUsuario") int idUsuario) {
        List<HabitoEcologico> habitos = uhS.findHabitosCompletadosPorUsuario(idUsuario);

        if (habitos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron hábitos completados por el usuario con el id: " + idUsuario);
        }

        List<HabitoEcologicoDTO> listaDTO = habitos.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HabitoEcologicoDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}

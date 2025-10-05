package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.EventoDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Evento;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IEventoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private IEventoService eS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public String insertar(@RequestBody EventoDTO dto) {
        ModelMapper m = new ModelMapper();
        Evento e = m.map(dto, Evento.class);
        eS.insert(e);
        return "Evento registrado correctamente";
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<EventoDTO> listar() {
        return eS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, EventoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<EventoDTO> obtenerPorId(@PathVariable("id") int id) {
        Evento evento = eS.listId(id);
        if (evento != null) {
            ModelMapper m = new ModelMapper();
            EventoDTO dto = m.map(evento, EventoDTO.class);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> actualizar(@PathVariable("id") int id, @RequestBody EventoDTO dto) {
        Evento eventoExistente = eS.listId(id);
        if (eventoExistente != null) {
            ModelMapper m = new ModelMapper();
            Evento eventoActualizado = m.map(dto, Evento.class);
            eventoActualizado.setIdEvento(id); // aseguramos que mantenga el ID
            eS.insert(eventoActualizado); // save() en JPA sirve para insertar/actualizar
            return new ResponseEntity<>("Evento actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Evento no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        Evento evento = eS.listId(id);
        if (evento != null) {
            eS.delete(id);
            return new ResponseEntity<>("Evento eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Evento no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}

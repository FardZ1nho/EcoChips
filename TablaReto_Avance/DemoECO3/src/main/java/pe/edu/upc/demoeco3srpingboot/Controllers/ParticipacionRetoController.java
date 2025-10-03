package com.github.fardz1nho.ecochips.controllers;

import com.github.fardz1nho.ecochips.dtos.ParticipacionRetoDTO;
import com.github.fardz1nho.ecochips.entities.ParticipacionReto;
import com.github.fardz1nho.ecochips.servicesinterfaces.IParticipacionRetoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/participaciones")
public class ParticipacionRetoController {
    @Autowired
    private IParticipacionRetoService prService;

    @GetMapping
    public List<ParticipacionRetoDTO> listar() {
        return prService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ParticipacionRetoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ParticipacionRetoDTO dto) {
        ModelMapper m = new ModelMapper();
        ParticipacionReto p = m.map(dto, ParticipacionReto.class);
        prService.insert(p);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ParticipacionRetoDTO dto) {
        ModelMapper m = new ModelMapper();
        ParticipacionReto p = m.map(dto,ParticipacionReto.class);
        ParticipacionReto existe = prService.listId(p.getIdParticipacion());
        if(existe==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + p.getIdParticipacion());
        }
        prService.update(p);
        return ResponseEntity.ok("Participacion con ID " + p.getIdParticipacion() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        ParticipacionReto dev = prService.listId(id);
        if(dev==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un participación con el ID: " + id);
        }
        prService.delete(id);
        return ResponseEntity.ok("Participación con el ID: " + id + " eliminado correctamente.");
    }
}

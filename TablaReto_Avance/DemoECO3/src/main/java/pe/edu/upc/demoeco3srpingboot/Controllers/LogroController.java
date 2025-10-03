package com.github.fardz1nho.ecochips.controllers;

import com.github.fardz1nho.ecochips.dtos.LogroDTO;
import com.github.fardz1nho.ecochips.entities.Logro;
import com.github.fardz1nho.ecochips.servicesinterfaces.ILogroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logros")
public class LogroController {
    @Autowired
    private ILogroService lService;

    @PostMapping
    public void insertar(@RequestBody LogroDTO dto) {
        ModelMapper m = new ModelMapper();
        Logro l= m.map(dto, Logro.class);
        lService.insert(l);
    }

    @GetMapping
    public List<LogroDTO> listar(){
        return lService.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LogroDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Delete(@PathVariable("id") Integer id) {
        Logro lo = lService.listId(id);
        if (lo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un Logro con el ID: " + id);
        }
        lService.delete(id);
        return ResponseEntity.ok("Logro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/{id}")
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

    @PutMapping
    public ResponseEntity<String> update(@RequestBody LogroDTO dto) {
        ModelMapper m = new ModelMapper();
        Logro lo = m.map(dto,Logro.class);
        Logro existe = lService.listId(lo.getIdLogro());
        if(existe==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un logro con el ID: " + lo.getIdLogro());
        }
        lService.update(lo);
        return ResponseEntity.ok("Logro con ID " + lo.getIdLogro() + " modificado correctamente.");
    }
}

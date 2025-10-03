package com.github.fardz1nho.ecochips.controllers;

import com.github.fardz1nho.ecochips.dtos.RetoDTO;
import com.github.fardz1nho.ecochips.entities.Reto;
import com.github.fardz1nho.ecochips.servicesinterfaces.IRetoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/retos")
public class RetoController {
    @Autowired
    private IRetoService rService;

    @PostMapping
    public void insertar(@RequestBody RetoDTO dto){
        ModelMapper m = new ModelMapper();
        Reto r = m.map(dto, Reto.class);
        rService.insert(r);
    }

    @GetMapping
    public List<RetoDTO> listar(){
        return rService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RetoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Reto dev = rService.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un reto con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RetoDTO dto = m.map(dev, RetoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Delete(@PathVariable("id") Integer id) {
        Reto dev = rService.listId(id);
        if (dev == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reto con el ID: " + id);
        }
        rService.delete(id);
        return ResponseEntity.ok("Reto con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody RetoDTO dto) {
        ModelMapper m = new ModelMapper();
        Reto r = m.map(dto,Reto.class);
        Reto existe = rService.listId(r.getIdReto());
        if(existe==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + r.getIdReto());
        }
        rService.update(r);
        return ResponseEntity.ok("Reto con ID " + r.getIdReto() + " modificado correctamente.");
    }

    @GetMapping("/totalRetos")
    public ResponseEntity<String> getTotalRetos(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        int total = rService.countRetosByFechas(fechaInicio, fechaFin);

        if(total == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron retos en el rango de fechas proporcionado ("
                            + fechaInicio + " a " + fechaFin + ")");
        }

        return ResponseEntity.ok("Total de retos encontrados entre "
                + fechaInicio + " y " + fechaFin + ": " + total);
    }
}

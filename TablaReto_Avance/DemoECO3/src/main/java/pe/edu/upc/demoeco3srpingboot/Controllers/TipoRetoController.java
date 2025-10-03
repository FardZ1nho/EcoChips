package com.github.fardz1nho.ecochips.controllers;

import com.github.fardz1nho.ecochips.dtos.TipoRetoConteoDTO;
import com.github.fardz1nho.ecochips.dtos.TipoRetoDTO;
import com.github.fardz1nho.ecochips.entities.TipoReto;
import com.github.fardz1nho.ecochips.servicesinterfaces.ITipoRetoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiporeto")
public class TipoRetoController {
    @Autowired
    private ITipoRetoService tService;

    @PostMapping
    public void insertar(@RequestBody TipoRetoDTO dto){
        ModelMapper m = new ModelMapper();
        TipoReto t = m.map(dto, TipoReto.class);
        tService.insert(t);
    }

    @GetMapping
    public List<TipoRetoDTO> listar(){
        return tService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TipoRetoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Delete(@PathVariable("id") Integer id) {
        TipoReto dev = tService.listId(id);
        if (dev == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reto-tipo con el ID: " + id);
        }
        tService.delete(id);
        return ResponseEntity.ok("Reto-tipo con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        TipoReto dev = tService.listId(id);
        if (dev == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un reto con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TipoRetoDTO dto = m.map(dev, TipoRetoDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> update(@RequestBody TipoRetoDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoReto t = m.map(dto,TipoReto.class);
        TipoReto existe = tService.listId(t.getIdTipoReto());
        if(existe==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + t.getIdTipoReto());
        }
        tService.update(t);
        return ResponseEntity.ok("Tipo reto con ID " + t.getIdTipoReto() + " modificado correctamente.");
    }

    @GetMapping("/conteoRetos")
    public ResponseEntity<?> TipoXretos(){
        List<TipoRetoConteoDTO> dtoList = new ArrayList<>();
        List<String[]> fila = tService.TiposXretos();
        if (fila.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron tipos de reto");
        }
        for (String[] columna : fila){
            TipoRetoConteoDTO dto = new TipoRetoConteoDTO();
            dto.setNombreTipoReto(columna[0]);
            dto.setConteo(Integer.parseInt(columna[1]));
            dtoList.add(dto);
        }
        return ResponseEntity.ok(dtoList);
    }
}

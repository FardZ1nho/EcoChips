package pe.edu.upc.demoeco3springboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3springboot.DTOs.TipoRetoDTO;
import pe.edu.upc.demoeco3springboot.Entities.TipoReto;
import pe.edu.upc.demoeco3springboot.ServiceInterface.ITipoRetoService;

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
    public void eliminar(@PathVariable("id") Long id){
        tService.delete(id);
    }

    @GetMapping("/{id}")
    public TipoRetoDTO listarId(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        return m.map(tService.listId(id), TipoRetoDTO.class);
    }
}

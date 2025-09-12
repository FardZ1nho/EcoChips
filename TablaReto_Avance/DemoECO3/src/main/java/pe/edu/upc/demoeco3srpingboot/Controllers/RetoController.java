package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.RetoDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Reto;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRetoService;

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

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        rService.delete(id);
    }

    @GetMapping("/{id}")
    public RetoDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        return m.map(rService.listId(id), RetoDTO.class);
    }
}

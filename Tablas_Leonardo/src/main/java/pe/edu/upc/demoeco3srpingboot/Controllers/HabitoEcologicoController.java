package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.HabitoEcologicoDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IHabitoEcologicoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/habitosecologicos")
public class HabitoEcologicoController {
    @Autowired
    private IHabitoEcologicoService hS;
    @GetMapping
    public List<HabitoEcologicoDTO> list(){
        return hS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, HabitoEcologicoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insert(@RequestBody HabitoEcologicoDTO dto) {
        ModelMapper m = new ModelMapper();
        HabitoEcologico h=m.map(dto,HabitoEcologico.class);
        hS.insert(h);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listId(@PathVariable("id") Integer id) {
        HabitoEcologico dev = hS.listId(id);
        if(dev==null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un habito con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        HabitoEcologicoDTO dto = m.map(dev, HabitoEcologicoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        HabitoEcologico dev = hS.listId(id);
        if(dev==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un habito con el ID: " + id);
        }
        hS.delete(id);
        return ResponseEntity.ok("Habito con el ID: " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody HabitoEcologicoDTO dto) {
        ModelMapper m = new ModelMapper();
        HabitoEcologico h = m.map(dto,HabitoEcologico.class);
        HabitoEcologico existe = hS.listId(h.getIdHabitoEcologico());
        if(existe==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + h.getIdHabitoEcologico());
        }
        hS.update(h);
        return ResponseEntity.ok("Habito con ID " + h.getIdHabitoEcologico() + " modificado correctamente.");
    }

    @GetMapping("/busquedas")
    public ResponseEntity<?> buscar(@RequestParam String tituloHabito) {
        List<HabitoEcologico> habitos = hS.buscar(tituloHabito);
        if(habitos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron hábitos con el título: " + tituloHabito);
        }
        List<HabitoEcologicoDTO> listaDTO = habitos.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HabitoEcologicoDTO.class);}).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}

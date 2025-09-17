package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.HabitoEcologicoDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.RecompensaDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Repositories.IRecompensaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRecompensaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recompensas")
public class RecompensaController {
    @Autowired
    private IRecompensaService rS;

    @GetMapping
    public List<RecompensaDTO> list(){
        return rS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,RecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody RecompensaDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Recompensa r=m.map(dto,Recompensa.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listaId(@PathVariable("id") Integer id) {
        Recompensa r = rS.listId(id);
        if (r == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe una recompensa con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecompensaDTO dto = m.map(r, RecompensaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/puntos/{costoPuntos}")
    public List<RecompensaDTO> listByCostoPuntos(@PathVariable("costoPuntos") int costoPuntos) {
        return rS.listcostoPuntos(costoPuntos)
                .stream()
                .map(y -> {
                    ModelMapper m = new ModelMapper();
                    return m.map(y, RecompensaDTO.class);
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/busqueda/{tituloRecompensa}")
    public ResponseEntity<?> buscarTitulo(@PathVariable("tituloRecompensa") String tituloRecompensa) {
        List<Recompensa> recompensas = rS.buscarTitulo(tituloRecompensa);

        if (recompensas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron recompensas con el título: " + tituloRecompensa);
        }

        ModelMapper mapper = new ModelMapper(); // Crear solo una vez
        List<RecompensaDTO> listaDTO = recompensas.stream()
                .map(r -> mapper.map(r, RecompensaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}

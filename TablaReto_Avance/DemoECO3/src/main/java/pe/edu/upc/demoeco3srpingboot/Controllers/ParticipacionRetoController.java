package pe.edu.upc.demoeco3springboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3springboot.DTOs.ParticipacionRetoDTO;
import pe.edu.upc.demoeco3springboot.Entities.ParticipacionReto;
import pe.edu.upc.demoeco3springboot.ServiceInterface.IParticipacionRetoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/participaciones")
public class ParticipacionRetoController {
    @Autowired
    private IParticipacionRetoService prService;

    @GetMapping
    public List<ParticipacionRetoDTO> listar() {
        ModelMapper m = new ModelMapper();
        return prService.list().stream().map(x -> m.map(x,
                        ParticipacionRetoDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ParticipacionRetoDTO dto) {
        ModelMapper m = new ModelMapper();
        ParticipacionReto p = m.map(dto, ParticipacionReto.class);
        prService.insert(p);
    }
}

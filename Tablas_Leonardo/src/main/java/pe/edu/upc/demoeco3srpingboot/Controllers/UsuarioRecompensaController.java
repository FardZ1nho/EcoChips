package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioRecompensaDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUsuarioRecompensaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecompensaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/canjes")
public class UsuarioRecompensaController {
    @Autowired
    private IUsuarioRecompensaService urS;

    @GetMapping("/dtos")
    public List<UsuarioRecompensaDTO> list(){
        return urS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioRecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioRecompensaDTO dto)
    {
        ModelMapper m = new ModelMapper();
        UsuarioRecompensa ur =m.map(dto,UsuarioRecompensa.class);
        urS.insert(ur);
    }
}

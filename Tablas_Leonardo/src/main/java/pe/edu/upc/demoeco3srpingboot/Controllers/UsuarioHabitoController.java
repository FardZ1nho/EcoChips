package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioHabitoDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioRecompensaDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioHabito;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioHabitoService;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecompensaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/progreso-habitos")
public class UsuarioHabitoController {
    @Autowired
    private IUsuarioHabitoService uhS;

    @PostMapping
    public void insert(@RequestBody UsuarioHabitoDTO dto)
    {
        ModelMapper m = new ModelMapper();
        UsuarioHabito uh =m.map(dto,UsuarioHabito.class);
        uhS.insert(uh);
    }

    @GetMapping("/dtos")
    public List<UsuarioHabitoDTO> list(){
        return uhS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioHabitoDTO.class);
        }).collect(Collectors.toList());
    }
}

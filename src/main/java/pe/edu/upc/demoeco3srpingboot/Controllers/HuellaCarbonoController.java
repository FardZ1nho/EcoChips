package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.HuellaCarbonoDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;
import pe.edu.upc.demoeco3srpingboot.Entities.HuellaCarbono;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.IActividadRepository;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUserRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IHuellaCarbonoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/huellacarbono")
public class HuellaCarbonoController {

    @Autowired
    private IHuellaCarbonoService huellaCarbonoService;

    @Autowired
    private IUserRepository usuarioRepo;

    @Autowired
    private IActividadRepository actividadRepo;

    private final ModelMapper modelMapper = new ModelMapper();

    // Listar todo
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<HuellaCarbonoDTO> list() {
        return huellaCarbonoService.list().stream()
                .map(h -> {
                    HuellaCarbonoDTO dto = modelMapper.map(h, HuellaCarbonoDTO.class);
                    dto.setIdUsuario(h.getUsuario().getIdUsuario());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Listar por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public HuellaCarbonoDTO listarId(@PathVariable("id") Integer id) {
        HuellaCarbono h = huellaCarbonoService.listId(id);
        if (h == null) return null;

        HuellaCarbonoDTO dto = modelMapper.map(h, HuellaCarbonoDTO.class);
        dto.setIdUsuario(h.getUsuario().getIdUsuario());
        return dto;
    }

    // Ins
    @PostMapping
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public String insertar(@RequestBody HuellaCarbonoDTO dto) {

        Usuario usuario = usuarioRepo.findById(dto.getIdUsuario()).orElse(null);
        if (usuario == null) return "Usuario no encontrado";

        if (dto.getIdActividades() == null || dto.getIdActividades().isEmpty())
            return "Debe seleccionar al menos una actividad";

        List<Actividad> actividades = actividadRepo.findAllById(dto.getIdActividades());
        if (actividades.isEmpty()) return "Ninguna actividad válida encontrada";

        HuellaCarbono h = modelMapper.map(dto, HuellaCarbono.class);
        h.setUsuario(usuario);
        h.setActividades(actividades);

        huellaCarbonoService.insert(h);
        return "Huella registrada correctamente";
    }

    // Mod
    @PutMapping
    @PreAuthorize("hasAnyAuthority(ADMIN','SOPORTE')")
    public String modificar(@RequestBody HuellaCarbonoDTO dto) {
        HuellaCarbono existente = huellaCarbonoService.listId(dto.getIdHuella());
        if (existente == null) return "No se puede modificar. No existe un registro con el ID: " + dto.getIdHuella();

        Usuario usuario = usuarioRepo.findById(dto.getIdUsuario()).orElse(null);
        if (usuario == null) return "Usuario no encontrado";

        List<Actividad> actividades = actividadRepo.findAllById(dto.getIdActividades());
        if (actividades.isEmpty()) return "Ninguna actividad válida encontrada";

        HuellaCarbono h = modelMapper.map(dto, HuellaCarbono.class);
        h.setUsuario(usuario);
        h.setActividades(actividades);

        huellaCarbonoService.update(h);
        return "Registro con ID " + dto.getIdHuella() + " modificado correctamente.";
    }

    // Del
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public String eliminar(@PathVariable("id") Integer id) {
        HuellaCarbono h = huellaCarbonoService.listId(id);
        if (h == null) return "No existe un registro con el ID: " + id;

        huellaCarbonoService.delete(id);
        return "Registro con ID " + id + " eliminado correctamente.";
    }

    // Promedio global de CO2 entre fechas
    @GetMapping("/admin/promedioCO2")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public Double promedioCO2Global(@RequestParam("inicio") String inicioStr,
                                    @RequestParam("fin") String finStr) {
        LocalDate inicio = LocalDate.parse(inicioStr);
        LocalDate fin = LocalDate.parse(finStr);

        return huellaCarbonoService.calcularPromedioCO2TodosUsuarios(inicio, fin);
    }
    // Promedio CO2 entre fechas x usuario
    @GetMapping("/usuario/promedioCO2")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public Double promedioCO2Usuario(
            @RequestParam("idUsuario") int idUsuario,
            @RequestParam("inicio") String inicioStr,
            @RequestParam("fin") String finStr
    ) {
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return 0.0;
        }

        LocalDate inicio = LocalDate.parse(inicioStr);
        LocalDate fin = LocalDate.parse(finStr);

        return huellaCarbonoService.calcularPromedioCO2(usuario, inicio, fin);
    }
}
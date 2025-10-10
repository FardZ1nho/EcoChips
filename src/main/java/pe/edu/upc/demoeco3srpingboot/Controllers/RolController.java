package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.RolDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Rol;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUserRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Roles")
public class RolController {
    @Autowired
    private IRolService rS;
    @Autowired
    private IUserRepository uR;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RolDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String insertar(@RequestBody RolDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);

        Usuario usuario = uR.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        r.setUsuario(usuario);
        rS.insert(r);
        return "Reto registrado correctamente";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<?> listarId(@PathVariable ("id") Integer id)
    {
        Rol rol = rS.listId(id);
        if(rol ==null)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El rol no existe" +id);
        }

        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rol, RolDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id)
    {
        Rol rol = rS.listId(id);
        if (rol == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID" + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Registro con Id" +id+ "eliminado Correctamente");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Rol r=m.map(dto,Rol.class);

        Rol existente = rS.listId(r.getIdRol());
        if (existente == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID" + r.getIdRol());
        }

        rS.update(r);
        return  ResponseEntity.ok("Registro con Id" +r.getIdRol()+"modificado correctamente");
    }

    @GetMapping("/buscar/{nombre}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<RolDTO> buscarPorNombre(@PathVariable("nombre") String nombre)
    {
        return rS.buscarR(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, RolDTO.class);
        }).collect(Collectors.toList());
    }
}

package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.*;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.IProgresoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuarios")
public class UserController {
    @Autowired
    private IUserService uS;

    @Autowired
    private IProgresoRepository progresoRepo;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<UserNoPassDTO> listar(){
        return uS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, UserNoPassDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public String insertar(@RequestBody UserDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.insert(u);
        return "Usuario registrado correctamente";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE','CLIENT')")
    public ResponseEntity<?> listarId(@PathVariable ("id") Integer id)
    {
        Usuario us = uS.listId(id);
        if(us ==null)
        {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe" +id);
        }
        ModelMapper m = new ModelMapper();
        UserNoPassDTO dto = m.map(us, UserNoPassDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id)
    {
        Usuario us = uS.listId(id);
        if (us == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID" + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Registro con Id" +id+ "eliminado Correctamente");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE','CLIENT')")
    public ResponseEntity<String> modificar(@RequestBody UserDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);

        Usuario existente = uS.listId(u.getIdUsuario());
        if (existente == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID" + u.getIdUsuario());
        }

        //Actualizar si pasa validaciones
        uS.update(u);
        return  ResponseEntity.ok("Registro con Id" +u.getIdUsuario()+"modificado correctamente");
    }

    @GetMapping("/nivel/{nivel}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<?> listarPorNivel(@PathVariable("nivel") int nivel) {
        List<Usuario> usuarios = uS.findByNivel(nivel);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen usuarios con nivel " + nivel);
        }

        List<UserDTO> listaDTO = usuarios.stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UserDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/resumen/nivel/{nivel}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<?> listarResumenPorNivel(@PathVariable("nivel") int nivel) {
        List<Usuario> usuarios = uS.findByNivel(nivel);

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen usuarios con nivel " + nivel);
        }

        List<UsuarioNivelDTO> listaDTO = usuarios.stream().map(u -> {
            UsuarioNivelDTO dto = new UsuarioNivelDTO();
            dto.setNombre(u.getNombre());
            dto.setNivel(u.getNivel());

            int puntosTotales = progresoRepo.sumarPuntosPorUsuario(u.getIdUsuario());
            dto.setPuntos(puntosTotales);

            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/logros-ranking")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<List<UsuarioLogroDTO>> obtenerUsuariosConLogros() {
        List<Object[]> resultados = uS.obtenerUsuariosConConteoLogros();

        List<UsuarioLogroDTO> ranking = resultados.stream()
                .map(row -> new UsuarioLogroDTO(
                        (String) row[0],
                        ((Number) row[1]).longValue()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(ranking);
    }

    @GetMapping("/puntaje-ranking")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public ResponseEntity<List<UsuarioPuntajeDTO>> obtenerUsuariosConMayorPuntaje() {
        List<Object[]> resultados = uS.obtenerUsuariosConMayorPuntaje();

        List<UsuarioPuntajeDTO> ranking = resultados.stream()
                .map(row -> new UsuarioPuntajeDTO(
                        (String) row[0],
                        ((Number) row[1]).longValue()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(ranking);
    }
}
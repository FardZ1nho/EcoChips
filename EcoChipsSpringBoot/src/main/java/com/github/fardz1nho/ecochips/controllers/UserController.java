package com.github.fardz1nho.ecochips.controllers;


import com.github.fardz1nho.ecochips.dtos.UserDTO;
import com.github.fardz1nho.ecochips.entities.Usuario;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import com.github.fardz1nho.ecochips.servicesinterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuarios")
public class UserController {
    @Autowired
    private IUserService uS;
    @GetMapping
    public List<UserDTO> listar(){
        return uS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UserDTO dto)
    {
        ModelMapper m = new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.insert(u);
    }

    @GetMapping("/{id}")
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
        UserDTO dto = m.map(us, UserDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
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



}

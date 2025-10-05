package pe.edu.upc.demoeco3srpingboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3srpingboot.DTOs.RecompensaDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.RecompensaPopularDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioHabitoDTO;
import pe.edu.upc.demoeco3srpingboot.DTOs.UsuarioRecompensaDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioHabito;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUsuarioRecompensaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecompensaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/canjes")
public class UsuarioRecompensaController {

    @Autowired
    private IUsuarioRecompensaService usuarioRecompensaService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public List<UsuarioRecompensaDTO> listar() {
        return usuarioRecompensaService.listar().stream()
                .map(ur -> {
                    UsuarioRecompensaDTO dto = new UsuarioRecompensaDTO();
                    dto.setIdUsuarioRecompensa(ur.getIdUsuarioRecompensa());
                    dto.setIdUsuario(ur.getUsuario() != null ? ur.getUsuario().getIdUsuario() : 0);
                    dto.setIdRecompensa(ur.getRecompensa() != null ? ur.getRecompensa().getIdRecompensa() : 0);
                    dto.setFechaCanje(ur.getFechaAsignacion());
                    return dto;
                }).collect(Collectors.toList());
    }

    @GetMapping("/usuario/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN','SOPORTE')")
    public List<UsuarioRecompensaDTO> listarPorUsuario(@PathVariable int idUsuario) {
        return usuarioRecompensaService.listarPorUsuario(idUsuario).stream()
                .map(ur -> {
                    UsuarioRecompensaDTO dto = new UsuarioRecompensaDTO();
                    dto.setIdUsuarioRecompensa(ur.getIdUsuarioRecompensa());
                    dto.setIdUsuario(ur.getUsuario() != null ? ur.getUsuario().getIdUsuario() : 0);
                    dto.setIdRecompensa(ur.getRecompensa() != null ? ur.getRecompensa().getIdRecompensa() : 0);
                    dto.setFechaCanje(ur.getFechaAsignacion());
                    return dto;
                }).collect(Collectors.toList());
    }

    @PostMapping("/canjear")
    @PreAuthorize("hasAuthority('CLIENT')")
    public String canjear(@RequestParam int idUsuario, @RequestParam int idRecompensa) {
        return usuarioRecompensaService.canjearRecompensa(idUsuario, idRecompensa);
    }

    @PutMapping("/subirNivel/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public String asignarCanjePorSubirNivel(@PathVariable int idUsuario) {
        usuarioRecompensaService.asignarCanjePorSubirNivel(idUsuario);
        return "Se ha asignado un canje por subir de nivel al usuario con ID " + idUsuario;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SOPORTE')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        UsuarioRecompensa ur = usuarioRecompensaService.listarPorId(id);
        if (ur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un canje con ID: " + id);
        }
        usuarioRecompensaService.eliminar(id);
        return ResponseEntity.ok("Canje con ID " + id + " eliminado correctamente.");
    }
}

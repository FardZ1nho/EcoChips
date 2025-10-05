package pe.edu.upc.demoeco3srpingboot.DTOs;


import pe.edu.upc.demoeco3srpingboot.Entities.Evento;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.time.LocalDate;

public class UsuarioEventoDTO {

    private int idUsuarioEvento;
    private int usuarioId;
    private int eventoId;
    private LocalDate fechaRegistro;

    public int getIdUsuarioEvento() {
        return idUsuarioEvento;
    }

    public void setIdUsuarioEvento(int idUsuarioEvento) {
        this.idUsuarioEvento = idUsuarioEvento;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getUsuarioId() {return usuarioId;}

    public void setUsuarioId(int usuarioId) {this.usuarioId = usuarioId;}

    public int getEventoId() {return eventoId;}

    public void setEventoId(int eventoId) {this.eventoId = eventoId;}
}
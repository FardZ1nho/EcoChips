package pe.edu.upc.demoeco3srpingboot.DTOs;

import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;
import pe.edu.upc.demoeco3srpingboot.Entities.Evento;
import pe.edu.upc.demoeco3srpingboot.Entities.Reto;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.time.LocalDateTime;

public class NotificacionDTO {
    private int idNotificacion;
    private int idUsuario;
    private int idActividad;
    private int idReto;
    private int idEvento;
    private String tipo;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCrea;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdReto() {
        return idReto;
    }

    public void setIdReto(int idReto) {
        this.idReto = idReto;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(LocalDateTime fechaCrea) {
        this.fechaCrea = fechaCrea;
    }
}

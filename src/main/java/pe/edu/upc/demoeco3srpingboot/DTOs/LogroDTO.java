package pe.edu.upc.demoeco3srpingboot.DTOs;

import java.time.LocalDate;

public class LogroDTO {
    private int idLogro;
    private int idUsuario;
    private int idReto;
    private String descripcion;
    private LocalDate fechaObtencion;

    public LogroDTO(){}

    public LogroDTO(int idLogro, int idUsuario, int idReto, String descripcion, LocalDate fechaObtencion) {
        this.idLogro = idLogro;
        this.idUsuario = idUsuario;
        this.idReto = idReto;
        this.descripcion = descripcion;
        this.fechaObtencion = fechaObtencion;
    }

    public int getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(int idLogro) {
        this.idLogro = idLogro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdReto() {
        return idReto;
    }

    public void setIdReto(int idReto) {
        this.idReto = idReto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(LocalDate fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }
}

package pe.edu.upc.demoeco3srpingboot.DTOs;

import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;

import java.time.LocalDate;

public class UsuarioHabitoDTO {
    private int idUsuarioHabito;
    private boolean cumplido;
    private LocalDate fechaInicio;
    private Usuario usuario;
    private HabitoEcologico habito;

    public int getIdUsuarioHabito() {
        return idUsuarioHabito;
    }

    public void setIdUsuarioHabito(int idUsuarioHabito) {
        this.idUsuarioHabito = idUsuarioHabito;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HabitoEcologico getHabito() {
        return habito;
    }

    public void setHabito(HabitoEcologico habito) {
        this.habito = habito;
    }
}

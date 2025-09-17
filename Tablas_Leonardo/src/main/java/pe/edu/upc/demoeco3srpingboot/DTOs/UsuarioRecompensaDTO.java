package pe.edu.upc.demoeco3srpingboot.DTOs;

import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;

import java.time.LocalDate;

public class UsuarioRecompensaDTO {
    private int idUsuarioRecompensa;
    private LocalDate fechaCanje;
    private Usuario usuario;
    private Recompensa recompensa;

    public int getIdUsuarioRecompensa() {
        return idUsuarioRecompensa;
    }

    public void setIdUsuarioRecompensa(int idUsuarioRecompensa) {
        this.idUsuarioRecompensa = idUsuarioRecompensa;
    }

    public LocalDate getFechaCanje() {
        return fechaCanje;
    }

    public void setFechaCanje(LocalDate fechaCanje) {
        this.fechaCanje = fechaCanje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }
}

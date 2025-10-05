package pe.edu.upc.demoeco3srpingboot.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.time.LocalDate;

public class UsuarioHabitoDTO {
    private int idUsuarioHabito;
    private boolean cumplido;
    private LocalDate fechaInicio;
    private int idUsuario;
    private int idHabitoEcologico;

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

    public int getIdUsuario() {return idUsuario;}

    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdHabitoEcologico() {return idHabitoEcologico;}

    public void setIdHabitoEcologico(int idHabitoEcologico) {this.idHabitoEcologico = idHabitoEcologico;}
}

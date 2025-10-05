package pe.edu.upc.demoeco3srpingboot.DTOs;

import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.time.LocalDate;

public class UsuarioRecompensaDTO {
    private int idUsuarioRecompensa;
    private LocalDate fechaCanje;
    private int idUsuario;
    private int idRecompensa;

    public int getIdUsuarioRecompensa() {return idUsuarioRecompensa;}

    public void setIdUsuarioRecompensa(int idUsuarioRecompensa) {this.idUsuarioRecompensa = idUsuarioRecompensa;}

    public LocalDate getFechaCanje() {return fechaCanje;}

    public void setFechaCanje(LocalDate fechaCanje) {this.fechaCanje = fechaCanje;}

    public int getIdUsuario() {return idUsuario;}

    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

    public int getIdRecompensa() {return idRecompensa;}

    public void setIdRecompensa(int idRecompensa) {this.idRecompensa = idRecompensa;}
}

package pe.edu.upc.demoeco3srpingboot.DTOs;

import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.time.LocalDate;

public class UsuarioRecompensaDTO {
    private LocalDate fechaCanje;
    private int idUsuario;


    public LocalDate getFechaCanje() {return fechaCanje;}

    public void setFechaCanje(LocalDate fechaCanje) {this.fechaCanje = fechaCanje;}

    public int getIdUsuario() {return idUsuario;}

    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}
}

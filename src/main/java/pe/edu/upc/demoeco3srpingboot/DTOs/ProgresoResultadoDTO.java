package pe.edu.upc.demoeco3srpingboot.DTOs;

public class ProgresoResultadoDTO {
    private int idUsuario;
    private int nivel;
    private int canjesDisponibles;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCanjesDisponibles() {
        return canjesDisponibles;
    }

    public void setCanjesDisponibles(int canjesDisponibles) {
        this.canjesDisponibles = canjesDisponibles;
    }
}

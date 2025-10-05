package pe.edu.upc.demoeco3srpingboot.DTOs;

public class UsuarioNivelDTO {
    private String nombre;
    private int puntos;
    private int nivel;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
}

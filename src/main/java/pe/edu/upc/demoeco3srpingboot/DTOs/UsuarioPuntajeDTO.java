package pe.edu.upc.demoeco3srpingboot.DTOs;

public class UsuarioPuntajeDTO {
    private String nombre;
    private Long puntajeTotal;

    public UsuarioPuntajeDTO(String nombre, Long puntajeTotal) {
        this.nombre = nombre;
        this.puntajeTotal = puntajeTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(Long puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
}

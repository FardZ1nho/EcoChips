package pe.edu.upc.demoeco3srpingboot.DTOs;

public class UsuarioLogroDTO {
    private String nombre;
    private Long cantidadLogros;

    public UsuarioLogroDTO(String nombre, Long cantidadLogros) {
        this.nombre = nombre;
        this.cantidadLogros = cantidadLogros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidadLogros() {
        return cantidadLogros;
    }

    public void setCantidadLogros(Long cantidadLogros) {
        this.cantidadLogros = cantidadLogros;
    }
}

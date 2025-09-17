package pe.edu.upc.demoeco3springboot.DTOs;

public class LogroDTO {
    private Long idLogro;
    private String nombre;
    private String descripcion;
    private Integer puntosOtorgados;
    private Long idParticipacionReto;

    public LogroDTO(){}

    public Long getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(Long idLogro) {
        this.idLogro = idLogro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPuntosOtorgados() {
        return puntosOtorgados;
    }

    public void setPuntosOtorgados(Integer puntosOtorgados) {
        this.puntosOtorgados = puntosOtorgados;
    }

    public Long getIdParticipacionReto() {
        return idParticipacionReto;
    }

    public void setIdParticipacionReto(Long idParticipacionReto) {
        this.idParticipacionReto = idParticipacionReto;
    }
}

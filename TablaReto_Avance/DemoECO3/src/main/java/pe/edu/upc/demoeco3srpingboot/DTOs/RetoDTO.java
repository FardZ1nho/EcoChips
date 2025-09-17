package pe.edu.upc.demoeco3springboot.DTOs;

import java.time.LocalDate;

public class RetoDTO {
    private Long idReto;
    private Long idTipoReto;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public RetoDTO() {}

    public RetoDTO(Long idReto, Long idTipoReto, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReto = idReto;
        this.idTipoReto = idTipoReto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Long getIdReto() {
        return idReto;
    }

    public void setIdReto(Long idReto) {
        this.idReto = idReto;
    }

    public Long getIdTipoReto() {
        return idTipoReto;
    }

    public void setIdTipoReto(Long idTipoReto) {
        this.idTipoReto = idTipoReto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}

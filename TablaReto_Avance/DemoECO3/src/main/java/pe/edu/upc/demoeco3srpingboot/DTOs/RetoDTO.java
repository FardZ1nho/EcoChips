package com.github.fardz1nho.ecochips.dtos;

import java.time.LocalDate;

public class RetoDTO {
    private int idReto;
    private int idTipoReto;
    private String titulo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public RetoDTO() {}

    public RetoDTO(int idReto, int idTipoReto, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReto = idReto;
        this.idTipoReto = idTipoReto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdReto() {
        return idReto;
    }

    public void setIdReto(int idReto) {
        this.idReto = idReto;
    }

    public int getIdTipoReto() {
        return idTipoReto;
    }

    public void setIdTipoReto(int idTipoReto) {
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

package pe.edu.upc.demoeco3srpingboot.DTOs;

import java.time.LocalDate;

public class SoporteSolicitudDTO {

    private int idSoporteSolicitud;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private String estado;

    public int getIdSoporteSolicitud() {return idSoporteSolicitud;}
    public void setIdSoporteSolicitud(int idSoporteSolicitud) {this.idSoporteSolicitud = idSoporteSolicitud;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}
}
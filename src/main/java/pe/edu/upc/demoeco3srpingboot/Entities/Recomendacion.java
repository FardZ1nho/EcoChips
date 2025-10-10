package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

@Entity

@Table(name = "Recomendacion")

public class Recomendacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecomendacion;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Recomendacion() {
    }

    public Recomendacion(int idRecomendacion, String titulo, String descripcion, String tipo) {
        this.idRecomendacion = idRecomendacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
}
package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Reto")
public class Reto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_reto")
    private Long idReto;

    @Column(name = "id_tipo_reto", nullable = false)
    private Long idTipoReto;;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "descripcion",nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    public Reto() {}

    public Reto(Long idReto, Long tipoReto, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReto = idReto;
        this.idTipoReto = tipoReto;
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

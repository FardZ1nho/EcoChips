package pe.edu.upc.demoeco3springboot.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Reto")
public class Reto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reto")
    private Long idReto;

    @ManyToOne
    @JoinColumn(name = "idTipoReto")
    private TipoReto tipoReto;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    public Reto() {}

    public Reto(Long idReto, TipoReto tipoReto, String titulo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReto = idReto;
        this.tipoReto = tipoReto;
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

    public TipoReto getTipoReto() {
        return tipoReto;
    }

    public void setTipoReto(TipoReto tipoReto) {
        this.tipoReto = tipoReto;
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

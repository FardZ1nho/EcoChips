package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "UsuarioRecomendacion")
public class UsuarioRecomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioRecomendacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRecomendacion", nullable = false)
    private Recomendacion recomendacion;

    @Column(name = "fechaAsignacion", nullable = false)
    private LocalDate fechaAsignacion;

    public UsuarioRecomendacion() {}

    public int getIdUsuarioRecomendacion() {
        return idUsuarioRecomendacion;
    }

    public void setIdUsuarioRecomendacion(int idUsuarioRecomendacion) {
        this.idUsuarioRecomendacion = idUsuarioRecomendacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recomendacion getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Recomendacion recomendacion) {
        this.recomendacion = recomendacion;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public UsuarioRecomendacion(int idUsuarioRecomendacion, Usuario usuario, Recomendacion recomendacion, LocalDate fechaAsignacion) {
        this.idUsuarioRecomendacion = idUsuarioRecomendacion;
        this.usuario = usuario;
        this.recomendacion = recomendacion;
        this.fechaAsignacion = fechaAsignacion;

    }
}

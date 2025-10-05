package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SoporteSolicitud")
public class SoporteSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSoporteSolicitud;

    @Column(name="titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name="descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name="fecha", nullable = false)
    private LocalDate fecha;

    @Column(name="estado", length = 50, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public SoporteSolicitud() {}

    public SoporteSolicitud(String titulo, String descripcion, LocalDate fecha, String estado, Usuario usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIdSoporteSolicitud() {
        return idSoporteSolicitud;
    }

    public void setIdSoporteSolicitud(int idSoporteSolicitud) {
        this.idSoporteSolicitud = idSoporteSolicitud;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

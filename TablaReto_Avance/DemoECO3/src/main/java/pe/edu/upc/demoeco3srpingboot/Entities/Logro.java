package pe.edu.upc.demoeco3springboot.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Logro")
public class Logro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLogro;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

    @Column(name = "fechaObtencion", nullable = false)
    private String fechaObtencion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idReto", nullable = false)
    private Reto reto;

    public Logro() {}

    public int getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(int idLogro) {
        this.idLogro = idLogro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(String fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reto getReto() {
        return reto;
    }

    public void setReto(Reto reto) {
        this.reto = reto;
    }
}

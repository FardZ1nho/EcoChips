package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "UsuarioRecompensa")
public class UsuarioRecompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioRecompensa;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRecompensa", nullable = false)
    private Recompensa recompensa;

    @Column(name = "fechaCanje", nullable = false)
    private LocalDate fechaCanje;

    public UsuarioRecompensa() {}

    public UsuarioRecompensa(int idUsuarioRecompensa, Usuario usuario, Recompensa recompensa, LocalDate fechaCanje) {
        this.idUsuarioRecompensa = idUsuarioRecompensa;
        this.usuario = usuario;
        this.recompensa = recompensa;
        this.fechaCanje = fechaCanje;
    }

    public int getIdUsuarioRecompensa() {
        return idUsuarioRecompensa;
    }

    public void setIdUsuarioRecompensa(int idUsuarioRecompensa) {
        this.idUsuarioRecompensa = idUsuarioRecompensa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

    public LocalDate getFechaCanje() {
        return fechaCanje;
    }

    public void setFechaCanje(LocalDate fechaCanje) {
        this.fechaCanje = fechaCanje;
    }
}

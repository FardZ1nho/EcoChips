package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "UsuarioEvento")
public class UsuarioEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioEvento;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    private Evento evento;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    public UsuarioEvento() {}

    public UsuarioEvento(int idUsuarioEvento, LocalDate fechaRegistro, Evento evento, Usuario usuario) {
        this.idUsuarioEvento = idUsuarioEvento;
        this.fechaRegistro = fechaRegistro;
        this.evento = evento;
        this.usuario = usuario;
    }

    public int getIdUsuarioEvento() {
        return idUsuarioEvento;
    }

    public void setIdUsuarioEvento(int idUsuarioEvento) {
        this.idUsuarioEvento = idUsuarioEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}

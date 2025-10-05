package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "UsuarioHabito")
public class UsuarioHabito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioHabito;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idHabitoEcologico", nullable = false)
    private HabitoEcologico habito;

    @Column(name = "Cumplido",nullable = false)
    private boolean cumplido;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    public UsuarioHabito() {}

    public UsuarioHabito(int idUsuarioHabito, Usuario usuario, HabitoEcologico habito, boolean cumplido, LocalDate fechaIniicio) {
        this.idUsuarioHabito = idUsuarioHabito;
        this.usuario = usuario;
        this.habito = habito;
        this.cumplido = cumplido;
        this.fechaInicio = fechaIniicio;
    }

    public int getIdUsuarioHabito() {
        return idUsuarioHabito;
    }

    public void setIdUsuarioHabito(int idUsuarioHabito) {
        this.idUsuarioHabito = idUsuarioHabito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HabitoEcologico getHabito() {
        return habito;
    }

    public void setHabito(HabitoEcologico habito) {
        this.habito = habito;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}

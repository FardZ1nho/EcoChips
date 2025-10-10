package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notificacion")

public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;


    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "idActividad")
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "idReto")
    private Reto reto;


    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;


    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "mensaje", length = 255, nullable = false)
    private String mensaje;

    @Column(name = "fechaCrea", nullable = false)
    private LocalDateTime fechaCrea;


    public Notificacion() {}

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Reto getReto() {
        return reto;
    }

    public void setReto(Reto reto) {
        this.reto = reto;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(LocalDateTime fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Notificacion(int idNotificacion, Usuario usuario, Actividad actividad, Reto reto, Evento evento,
                        String tipo, String titulo, String mensaje, LocalDateTime fechaCrea) {
        this.idNotificacion = idNotificacion;
        this.usuario = usuario;
        this.reto = reto;
        this.evento = evento;
        this.tipo = tipo;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCrea = fechaCrea;


    }

}


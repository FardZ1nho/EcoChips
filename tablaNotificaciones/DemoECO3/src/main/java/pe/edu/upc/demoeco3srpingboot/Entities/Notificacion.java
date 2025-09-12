package pe.edu.upc.demoeco3srpingboot.Entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notificacion")


public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "idActividad")
    private int idActividad;

    @Column(name = "idReto")
    private int idReto;

    @Column(name = "idEvento")
    private int idEvento;

    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "mensaje", length = 255, nullable = false)
    private String mensaje;

    @Column(name = "fechaCrea", nullable = false)
    private LocalDateTime fechaCrea;


    // Constructor
    public Notificacion() {}

    public Notificacion(int idUsuario, int idActividad, int idReto, int idEvento,
                        String tipo, String titulo, String mensaje, LocalDateTime fechaCrea) {
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
        this.idReto = idReto;
        this.idEvento = idEvento;
        this.tipo = tipo;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCrea = fechaCrea;
    }
    // Getters y Setters
    public int getIdNotificacion() {
        return idNotificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdReto() {
        return idReto;
    }

    public void setIdReto(int idReto) {
        this.idReto = idReto;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
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

    public void setActivo(boolean b) {
    }
}

package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Progreso")
public class Progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProgreso;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Puntos", nullable = false)
    private int puntos;

    @Column(name = "Estado", nullable = false)
    private boolean estado;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idActividad", nullable = false)
    private Actividad actividad;

    public Progreso() {}

    public Progreso(int idProgreso, LocalDate fecha, int puntos, boolean estado, Usuario usuario, Actividad actividad) {
        this.idProgreso = idProgreso;
        this.fecha = fecha;
        this.puntos = puntos;
        this.estado = estado;
        this.usuario = usuario;
        this.actividad = actividad;
    }

    public int getIdProgreso() { return idProgreso; }
    public void setIdProgreso(int idProgreso) { this.idProgreso = idProgreso; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }
}
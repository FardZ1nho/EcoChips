package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SoporteRespuesta")
public class SoporteRespuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column(name = "respuesta", length = 255, nullable = false)
    private String respuesta;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    // Relación con SoporteSolicitud (FK)
    @ManyToOne
    @JoinColumn(name = "idSolicitud", nullable = false)
    private SoporteSolicitud solicitud;

    public SoporteRespuesta() {}

    public SoporteRespuesta(String respuesta, LocalDate fecha, SoporteSolicitud solicitud) {
        this.respuesta = respuesta;
        this.fecha = fecha;
        this.solicitud = solicitud;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public SoporteSolicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SoporteSolicitud solicitud) {
        this.solicitud = solicitud;
    }
}


package pe.edu.upc.demoeco3srpingboot.DTOs;

import jakarta.persistence.*;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteSolicitud;

import java.time.LocalDate;

public class SoporteRespuestaDTO {
    private int idRespuesta;
    private String respuesta;
    private LocalDate fecha;
    private SoporteSolicitud solicitud;

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

package pe.edu.upc.demoeco3srpingboot.DTOs;

import jakarta.persistence.Column;

public class RecompensaDTO {
    private int idRecompensa;
    private String tituloRecompensa;
    private String descripcionRecompensa;
    private int costoPuntos;

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getTituloRecompensa() {
        return tituloRecompensa;
    }

    public void setTituloRecompensa(String tituloRecompensa) {
        this.tituloRecompensa = tituloRecompensa;
    }

    public String getDescripcionRecompensa() {
        return descripcionRecompensa;
    }

    public void setDescripcionRecompensa(String descripcionRecompensa) {
        this.descripcionRecompensa = descripcionRecompensa;
    }

    public int getCostoPuntos() {
        return costoPuntos;
    }

    public void setCostoPuntos(int costoPuntos) {
        this.costoPuntos = costoPuntos;
    }
}

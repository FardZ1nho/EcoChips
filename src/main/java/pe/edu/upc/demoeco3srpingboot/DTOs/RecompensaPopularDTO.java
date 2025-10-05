package pe.edu.upc.demoeco3srpingboot.DTOs;

public class RecompensaPopularDTO {
    private String tituloRecompensa;
    private String descripcionRecompensa;
    private int costoPuntos;
    private int totalCanjes;

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

    public int getTotalCanjes() {
        return totalCanjes;
    }

    public void setTotalCanjes(int totalCanjes) {
        this.totalCanjes = totalCanjes;
    }
}

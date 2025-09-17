package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recompensa")
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecompensa;

    @Column(name = "tituloRecompensa" ,length = 50, nullable = false)
    private String tituloRecompensa;

    @Column(name = "descripcionRecompensa", length = 255, nullable = false)
    private String descripcionRecompensa;

    @Column(name = "costoPuntos", length = 10, nullable = false)
    private int costoPuntos;

    public Recompensa() {}

    public Recompensa(int idRecompensa, String tituloRecompensa, String descripcionRecompensa, int costoPuntos) {
        this.idRecompensa = idRecompensa;
        this.tituloRecompensa = tituloRecompensa;
        this.descripcionRecompensa = descripcionRecompensa;
        this.costoPuntos = costoPuntos;
    }

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

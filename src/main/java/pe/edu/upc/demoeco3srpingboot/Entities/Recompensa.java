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

    @Column(name = "costoCanjes", nullable = false)
    private int costoCanjes;   // cambiado de costoPuntos a costoCanjes

    public Recompensa() {}

    public Recompensa(int idRecompensa, String tituloRecompensa, String descripcionRecompensa, int costoCanjes) {
        this.idRecompensa = idRecompensa;
        this.tituloRecompensa = tituloRecompensa;
        this.descripcionRecompensa = descripcionRecompensa;
        this.costoCanjes = costoCanjes;
    }

    public int getIdRecompensa() {return idRecompensa;}

    public void setIdRecompensa(int idRecompensa) {this.idRecompensa = idRecompensa;}

    public String getTituloRecompensa() {return tituloRecompensa;}

    public void setTituloRecompensa(String tituloRecompensa) {this.tituloRecompensa = tituloRecompensa;}

    public String getDescripcionRecompensa() {return descripcionRecompensa;}

    public void setDescripcionRecompensa(String descripcionRecompensa) {this.descripcionRecompensa = descripcionRecompensa;}

    public int getCostoCanjes() {return costoCanjes;}

    public void setCostoCanjes(int costoCanjes) {this.costoCanjes = costoCanjes;}

}

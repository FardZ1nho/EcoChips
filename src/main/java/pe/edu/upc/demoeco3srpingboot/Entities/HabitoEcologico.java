package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "HabitoEcologico")
public class HabitoEcologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHabitoEcologico;

    @Column(name = "tituloHabito", length = 100, nullable = false)
    private String tituloHabito;

    @Column(name = "descripcionHabito", length = 255, nullable = false)
    private String descripcionHabito;

    public HabitoEcologico() {}

    public HabitoEcologico(int idHabitoEcologico, String tituloHabito, String descripcionHabito) {
        this.idHabitoEcologico = idHabitoEcologico;
        this.tituloHabito = tituloHabito;
        this.descripcionHabito = descripcionHabito;
    }

    public int getIdHabitoEcologico() {return idHabitoEcologico;}

    public void setIdHabitoEcologico(int idHabitoEcologico) {this.idHabitoEcologico = idHabitoEcologico;}

    public String getTituloHabito() {return tituloHabito;}

    public void setTituloHabito(String tituloHabito) {this.tituloHabito = tituloHabito;}

    public String getDescripcionHabito() {return descripcionHabito;}

    public void setDescripcionHabito(String descripcionHabito) {this.descripcionHabito = descripcionHabito;}
}

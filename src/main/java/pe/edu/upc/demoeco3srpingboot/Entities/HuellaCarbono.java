package pe.edu.upc.demoeco3srpingboot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "huellacarbono")
public class HuellaCarbono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHuella;

    @Column(name = "valorCO2", nullable = false)
    private double valorCO2;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "huella_actividad",
            joinColumns = @JoinColumn(name = "idHuella"),
            inverseJoinColumns = @JoinColumn(name = "idActividad")
    )
    private List<Actividad> actividades;

    public HuellaCarbono() {}

    public HuellaCarbono(int idHuella, double valorCO2, LocalDate fecha, Usuario usuario, List<Actividad> actividades) {
        this.idHuella = idHuella;
        this.valorCO2 = valorCO2;
        this.fecha = fecha;
        this.usuario = usuario;
        this.actividades = actividades;
    }

    // Getters y Setters
    public int getIdHuella() { return idHuella; }
    public void setIdHuella(int idHuella) { this.idHuella = idHuella; }

    public double getValorCO2() { return valorCO2; }
    public void setValorCO2(double valorCO2) { this.valorCO2 = valorCO2; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Actividad> getActividades() { return actividades; }
    public void setActividades(List<Actividad> actividades) { this.actividades = actividades; }
}
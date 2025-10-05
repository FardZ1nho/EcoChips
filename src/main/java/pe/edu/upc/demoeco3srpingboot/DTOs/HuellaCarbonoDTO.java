package pe.edu.upc.demoeco3srpingboot.DTOs;

import java.time.LocalDate;
import java.util.List;

public class HuellaCarbonoDTO {
    private int idHuella;
    private double valorCO2;
    private LocalDate fecha;
    private int idUsuario;
    private List<Integer> idActividades;

    public int getIdHuella() { return idHuella; }
    public void setIdHuella(int idHuella) { this.idHuella = idHuella; }

    public double getValorCO2() { return valorCO2; }
    public void setValorCO2(double valorCO2) { this.valorCO2 = valorCO2; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public List<Integer> getIdActividades() { return idActividades; }
    public void setIdActividades(List<Integer> idActividades) { this.idActividades = idActividades; }
}

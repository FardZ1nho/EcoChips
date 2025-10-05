package pe.edu.upc.demoeco3srpingboot.DTOs;

public class PromedioHuellaCarbonoGlobalDTO {
    private double promedioCO2Global;
    private String fechaInicio;
    private String fechaFin;

    public double getPromedioCO2Global() {
        return promedioCO2Global;
    }

    public void setPromedioCO2Global(double promedioCO2Global) {
        this.promedioCO2Global = promedioCO2Global;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
package pe.edu.upc.demoeco3srpingboot.DTOs;

public class PromedioHuellaCarbonoDTO {
    private double promedioCO2;
    private String fechaInicio;
    private String fechaFin;

    public double getPromedioCO2() {
        return promedioCO2;
    }

    public void setPromedioCO2(double promedioCO2) {
        this.promedioCO2 = promedioCO2;
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


package pe.edu.upc.demoeco3srpingboot.DTOs;

public class GeneroParticipacionDTO {
    private String genero;
    private Long cantidadParticipantes;
    private Double edadPromedio;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(Long cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public Double getEdadPromedio() {
        return edadPromedio;
    }

    public void setEdadPromedio(Double edadPromedio) {
        this.edadPromedio = edadPromedio;
    }
}

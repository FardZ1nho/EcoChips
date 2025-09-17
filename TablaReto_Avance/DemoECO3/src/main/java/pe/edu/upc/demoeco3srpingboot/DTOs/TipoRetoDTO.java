package pe.edu.upc.demoeco3springboot.DTOs;

public class TipoRetoDTO {
    private Long idTipoReto;
    private String nombreTipoReto;

    public TipoRetoDTO(){}

    public Long getIdTipoReto() {
        return idTipoReto;
    }

    public void setIdTipoReto(Long idTipoReto) {
        this.idTipoReto = idTipoReto;
    }

    public String getNombreTipoReto() {
        return nombreTipoReto;
    }

    public void setNombreTipoReto(String nombreTipoReto) {
        this.nombreTipoReto = nombreTipoReto;
    }
}

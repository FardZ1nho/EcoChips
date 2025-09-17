package pe.edu.upc.demoeco3springboot.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TipoReto")
public class TipoReto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoReto;

    @Column(name = "nombreTipoReto", length = 50, nullable = false)
    private String nombreTipoReto;

    @OneToMany(mappedBy = "tipoReto")
    private List<Reto> retos;

    public TipoReto() {}

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

    public List<Reto> getRetos() {
        return retos;
    }

    public void setRetos(List<Reto> retos) {
        this.retos = retos;
    }
}

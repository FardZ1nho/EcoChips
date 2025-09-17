package pe.edu.upc.demoeco3springboot.ServiceInterface;

import pe.edu.upc.demoeco3springboot.Entities.TipoReto;

import java.util.List;

public interface ITipoRetoService {
    void insert(TipoReto tipoReto);
    List<TipoReto> list();
    void delete(Long idTipoReto);
    TipoReto listId(Long idTipoReto);
}

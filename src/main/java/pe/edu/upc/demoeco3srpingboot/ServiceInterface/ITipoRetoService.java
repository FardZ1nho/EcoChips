package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.TipoReto;

import java.util.List;

public interface ITipoRetoService {
    public void insert(TipoReto tipoReto);
    public List<TipoReto> list();
    public void update(TipoReto tipoReto);
    public void delete(int id);
    public TipoReto listId(int id);
    public List<String[]> TiposXretos();
}

package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;

import java.util.List;

public interface IRecompensaService {
    public List<Recompensa> list();
    public void insert(Recompensa recompensa);
    public Recompensa listId(int id);
    public List<Recompensa> listcostoPuntos(int costoPuntos);
    public List<Recompensa> buscarTitulo(String tituloRecompensa);
}

package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;

import java.util.List;

public interface IHabitoEcologicoService {
    public List<HabitoEcologico> list();
    public HabitoEcologico listId(int id);
    public void insert(HabitoEcologico habitoecologico);
    public void delete(int id);
    public void update(HabitoEcologico habitoecologico);
    public List<HabitoEcologico> buscar(String tituloHabito);
}

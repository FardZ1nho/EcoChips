package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.ParticipacionReto;

import java.util.List;

public interface IParticipacionRetoService {
    public List<ParticipacionReto> list();
    public void insert(ParticipacionReto participacionReto);
    public void update(ParticipacionReto participacionReto);
    public ParticipacionReto listId(int id);
    public void delete(int id);
}

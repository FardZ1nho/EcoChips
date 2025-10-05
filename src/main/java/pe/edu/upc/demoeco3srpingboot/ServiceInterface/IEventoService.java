package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Evento;

import java.util.List;

public interface IEventoService {

    public List<Evento> list();
    public Evento listId(int id);
    public void insert(Evento evento);
    void delete(int id);

    // UPDATE ACTUALIZAR
    void update(Evento evento);
}
package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;

import java.util.List;

public interface IActividadService {
    List<Actividad> list();
    Actividad listId(int id);
    void insert(Actividad actividad);
    void update(Actividad actividad);
    void delete(int id);
}

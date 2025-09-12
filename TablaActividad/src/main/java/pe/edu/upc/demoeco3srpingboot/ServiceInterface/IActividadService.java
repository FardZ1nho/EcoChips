package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;

import java.util.Collection;
import java.util.List;

public interface IActividadService {
    public List<Actividad> list();
    public Actividad listId(int id);
    public void insert(Actividad actividad);
    public void delete(int id);
    public void update(Actividad actividad);
}


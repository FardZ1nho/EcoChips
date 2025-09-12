package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Notificacion;


import java.util.Collection;
import java.util.List;

public interface INotificacionService {

    public List<Notificacion> list();
    public Notificacion listId(int id);
    public void insert(Notificacion notificacion);
}

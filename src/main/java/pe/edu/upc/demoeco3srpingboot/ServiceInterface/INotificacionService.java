package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    public List<Notificacion> list();
    public Notificacion listId(int id);
    public void insert(Notificacion notificacion);
    public void update(Notificacion notificacion);
    public void delete(int id);

    List<Notificacion> listByTipo(String tipo);   // US16, US17, US20
    void desactivarNotificacion(int id);          // US18
    void configurarRecordatorio(Notificacion n);  // US19
}
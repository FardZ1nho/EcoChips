package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Notificacion;
import pe.edu.upc.demoeco3srpingboot.Entities.Notificacion;
import pe.edu.upc.demoeco3srpingboot.Repositories.INotificacionRepository;
import pe.edu.upc.demoeco3srpingboot.Repositories.INotificacionRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.INotificacionService;

import java.util.List;

@Service

public class NotificacionServiceImplement implements INotificacionService {

    @Autowired
    private INotificacionRepository nS;

    @Override
    public List<Notificacion> list() {
        return nS.findAll();
    }

    @Override
    public Notificacion listId(int id) {
        return nS.findById(id).orElse(null);
    }

    @Override
    public void insert(Notificacion notificacion) {
        nS.save(notificacion);
    }
}


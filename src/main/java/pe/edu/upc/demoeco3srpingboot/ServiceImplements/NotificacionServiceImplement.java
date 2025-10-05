package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Notificacion;
import pe.edu.upc.demoeco3srpingboot.Repositories.INotificacionRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.INotificacionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public void update(Notificacion notificacion) {
        nS.save(notificacion);
    }

    @Override
    public List<Notificacion> listByTipo(String tipo) {
        return nS.findAll()
                .stream()
                .filter(n -> tipo.equalsIgnoreCase(n.getTipo()))
                .collect(Collectors.toList());
    }

    @Override
    public void desactivarNotificacion(int id) {
        Optional<Notificacion> op = nS.findById(id);
        if(op.isPresent()) {
            Notificacion n = op.get();
            n.setTipo("inactivo");
            nS.save(n);
        }
    }

    @Override
    public void configurarRecordatorio(Notificacion n) {
        n.setTipo("recordatorio");
        nS.save(n);
    }

    @Override
    public void delete(int id) {
        nS.deleteById(id);
    }
}
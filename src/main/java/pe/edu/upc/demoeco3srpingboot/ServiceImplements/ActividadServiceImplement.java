package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;
import pe.edu.upc.demoeco3srpingboot.Repositories.IActividadRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IActividadService;

import java.util.List;

@Service
public class ActividadServiceImplement implements IActividadService {
    @Autowired
    private IActividadRepository actividadRepo;

    @Override
    public List<Actividad> list() {return actividadRepo.findAll();}

    @Override
    public Actividad listId(int id) {return actividadRepo.findById(id).orElse(null);}

    @Override
    public void insert(Actividad actividad) {
        actividadRepo.save(actividad);
    }

    @Override
    public void update(Actividad actividad) { actividadRepo.save(actividad); }

    @Override
    public void delete(int id) {
        actividadRepo.deleteById(id);
    }

}

package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pe.edu.upc.demoeco3srpingboot.DTOs.ActividadDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;
import pe.edu.upc.demoeco3srpingboot.Repositories.IActividadRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IActividadService;

import java.util.List;

@Service
public class ActividadServiceImplement implements IActividadService {
    @Autowired
    private IActividadRepository aS;

    @Override
    public List<Actividad> list() {
        return aS.findAll();
    }
    @Override
    public Actividad listId(int id) {
        return aS.findById(id).orElse(null);
    }

    @Override
    public void insert(Actividad actividad) {
        aS.save(actividad);
    }

    @Override
    public void delete(int id) {
        aS.deleteById(id);
    }

    @Override
    public void update(Actividad actividad) {
        aS.save(actividad);
    }
}

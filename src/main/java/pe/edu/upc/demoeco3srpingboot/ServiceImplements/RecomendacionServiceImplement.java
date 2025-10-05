package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Recomendacion;
import pe.edu.upc.demoeco3srpingboot.Repositories.IRecomendacionRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRecomendacionService;

import java.util.List;

@Service
public class RecomendacionServiceImplement implements IRecomendacionService {

    @Autowired
    private IRecomendacionRepository rS;

    @Override
    public List<Recomendacion> list() {
        return rS.findAll();
    }

    @Override
    public Recomendacion listId(int id) {
        return rS.findById(id).orElse(null);
    }

    @Override
    public void insert(Recomendacion recomendacion) {
        rS.save(recomendacion);
    }

    @Override
    public void delete(int id) {rS.deleteById(id);
    }

    @Override
    public void update(Recomendacion recomendacion) { rS.save(recomendacion);
    }
}

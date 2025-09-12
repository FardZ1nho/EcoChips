package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Reto;
import pe.edu.upc.demoeco3srpingboot.Repositories.IRetoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRetoService;

import java.util.List;

@Service
public class RetoServiceImplement implements IRetoService {
    @Autowired
    private IRetoRepository rRepo;

    @Override
    public void insert(Reto reto){
        rRepo.save(reto);
    }

    @Override
    public List<Reto>list(){
        return rRepo.findAll();
    }

    @Override
    public void delete(int idReto){
        rRepo.deleteById(idReto);
    }

    @Override
    public Reto listId(int idReto){
        return rRepo.findById(idReto).orElse(new Reto());
    }
}

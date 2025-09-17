package pe.edu.upc.demoeco3springboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3springboot.Entities.Reto;
import pe.edu.upc.demoeco3springboot.Repositories.IRetoRepository;
import pe.edu.upc.demoeco3springboot.ServiceInterface.IRetoService;

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
    public List<Reto> list(){
        return rRepo.findAll();
    }

    @Override
    public void delete(Long idReto){
        rRepo.deleteById(idReto);
    }

    @Override
    public Reto listId(Long idReto){
        return rRepo.findById(idReto).orElse(new Reto());
    }
}

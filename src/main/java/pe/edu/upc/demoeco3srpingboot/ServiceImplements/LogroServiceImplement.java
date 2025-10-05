package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Logro;
import pe.edu.upc.demoeco3srpingboot.Repositories.ILogroRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ILogroService;

import java.util.List;

@Service
public class LogroServiceImplement implements ILogroService {
    @Autowired
    private ILogroRepository lRepo;

    @Override
    public void insert(Logro logro){
        lRepo.save(logro);
    }

    @Override
    public List<Logro> list(){
        return lRepo.findAll();
    }

    @Override
    public void delete(int id){
        lRepo.deleteById(id);
    }

    @Override
    public void update(Logro logro) {lRepo.save(logro);}

    @Override
    public Logro listId(int id){return lRepo.findById(id).orElse(new Logro());}
}

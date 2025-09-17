package pe.edu.upc.demoeco3springboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3springboot.Entities.Logro;
import pe.edu.upc.demoeco3springboot.Repositories.ILogroRepository;
import pe.edu.upc.demoeco3springboot.ServiceInterface.ILogroService;

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
    public List<Logro>list(){
        return lRepo.findAll();
    }

    @Override
    public void delete(int idLogro){
        lRepo.deleteById(idLogro);
    }

    @Override
    public Logro listId(int idLogro){
        return lRepo.findById(idLogro).orElse(new Logro());
    }
}

package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.ParticipacionReto;
import pe.edu.upc.demoeco3srpingboot.Repositories.IParticipacionRetoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IParticipacionRetoService;

import java.util.List;

@Service
public class ParticipacionRetoServiceImplement implements IParticipacionRetoService {
    @Autowired
    private IParticipacionRetoRepository prRepo;

    @Override
    public List<ParticipacionReto> list(){
        return prRepo.findAll();
    }

    @Override
    public ParticipacionReto listId(int id){
        return prRepo.findById(id).orElse(new ParticipacionReto());
    }

    @Override
    public void insert(ParticipacionReto participacionReto){
        prRepo.save(participacionReto);
    }

    @Override
    public void update(ParticipacionReto participacionReto) {
        prRepo.save(participacionReto);
    }

    @Override
    public void delete(int id) {
        prRepo.deleteById(id);
    }
}

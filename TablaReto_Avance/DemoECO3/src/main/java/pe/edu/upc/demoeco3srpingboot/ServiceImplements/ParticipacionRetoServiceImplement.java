package pe.edu.upc.demoeco3springboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3springboot.Entities.ParticipacionReto;
import pe.edu.upc.demoeco3springboot.Repositories.IParticipacionRetoRepository;
import pe.edu.upc.demoeco3springboot.ServiceInterface.IParticipacionRetoService;

import java.util.List;

@Service
public class ParticipacionRetoServiceImplement implements IParticipacionRetoService{
    @Autowired
    private IParticipacionRetoRepository prRepo;

    @Override
    public List<ParticipacionReto>list(){
        return prRepo.findAll();
    }

    @Override
    public void insert(ParticipacionReto participacionReto){
        prRepo.save(participacionReto);
    }
}

package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Repositories.IRecompensaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRecompensaService;

import java.util.List;

@Service
public class RecompensaServiceImplement implements IRecompensaService {
    @Autowired
    private IRecompensaRepository rS;

    @Override
    public List<Recompensa> list(){ return rS.findAll(); }

    @Override
    public void insert(Recompensa recompensa){rS.save(recompensa);}

    @Override
    public Recompensa listId(int id){ return rS.findById(id).orElse(null); }

    @Override
    public List<Recompensa> listcostoPuntos(int costoPuntos) {
        return rS.findByCostoPuntos(costoPuntos);
    }

    @Override
    public List<Recompensa> buscarTitulo(String tituloRecompensa) {
        return rS.findByTituloRecompensa(tituloRecompensa);
    }
}

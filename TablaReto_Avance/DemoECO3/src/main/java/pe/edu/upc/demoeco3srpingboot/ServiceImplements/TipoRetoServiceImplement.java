package pe.edu.upc.demoeco3springboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3springboot.Entities.TipoReto;
import pe.edu.upc.demoeco3springboot.Repositories.ITipoRetoRepository;
import pe.edu.upc.demoeco3springboot.ServiceInterface.ITipoRetoService;

import java.util.List;

@Service
public class TipoRetoServiceImplement implements ITipoRetoService {
    @Autowired
    private ITipoRetoRepository tRepo;

    @Override
    public void insert(TipoReto tipoReto) {
        tRepo.save(tipoReto);
    }

    @Override
    public List<TipoReto>list(){
        return tRepo.findAll();
    }

    @Override
    public void delete(Long idTipoReto){
        tRepo.deleteById(idTipoReto);
    }

    @Override
    public TipoReto listId(Long idTipoReto){
        return tRepo.findById(idTipoReto).orElse(new TipoReto());
    }
}

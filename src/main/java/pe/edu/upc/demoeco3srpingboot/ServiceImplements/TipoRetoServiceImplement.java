package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.TipoReto;
import pe.edu.upc.demoeco3srpingboot.Repositories.ITipoRetoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ITipoRetoService;

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
    public List<TipoReto> list(){
        return tRepo.findAll();
    }

    @Override
    public void update(TipoReto tipoReto) {
        tRepo.save(tipoReto);
    }

    @Override
    public void delete(int id){
        tRepo.deleteById(id);
    }

    @Override
    public TipoReto listId(int id){
        return tRepo.findById(id).orElse(new TipoReto());
    }

    @Override
    public List<String[]> TiposXretos(){
        return tRepo.TiposXretos();
    }
}

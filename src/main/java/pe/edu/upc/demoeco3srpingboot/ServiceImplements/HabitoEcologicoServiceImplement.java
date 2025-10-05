package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;
import pe.edu.upc.demoeco3srpingboot.Repositories.IHabitoEcologicoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IHabitoEcologicoService;

import java.util.List;

@Service
public class HabitoEcologicoServiceImplement implements IHabitoEcologicoService {
    @Autowired
    private IHabitoEcologicoRepository hS;

    @Override
    public List<HabitoEcologico> list() {return hS.findAll();}

    @Override
    public HabitoEcologico listId(int id) {return hS.findById(id).orElse(null);}

    @Override
    public void insert(HabitoEcologico habitoecologico) {hS.save(habitoecologico);}

    @Override
    public void delete(int id) {hS.deleteById(id);}

    @Override
    public void update(HabitoEcologico habitoecologico) {hS.save(habitoecologico);}

    @Override
    public List<HabitoEcologico> buscar(String tituloHabito) {return hS.buscar(tituloHabito);}
}

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
    private IRecompensaRepository rR;

    @Override
    public void insertar(Recompensa recompensa) {
        rR.save(recompensa);
    }

    @Override
    public void eliminar(int id) {
        rR.deleteById(id);
    }

    @Override
    public void actualizar(Recompensa recompensa) {
        rR.save(recompensa);
    }

    @Override
    public List<Recompensa> listar() {
        return rR.findAll();
    }

    @Override
    public Recompensa listarPorId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public List<Recompensa> buscarPorCostoCanjesMenorIgual(int canjes) {
        return rR.findByCostoCanjesLessThanEqual(canjes);
    }

    @Override
    public List<Recompensa> buscarPorCostoCanjes(int canjes) {
        return rR.findByCostoCanjes(canjes);
    }

    @Override
    public List<Recompensa> buscarPorTitulo(String titulo) {
        return rR.findByTituloRecompensaContainingIgnoreCase(titulo);
    }
}

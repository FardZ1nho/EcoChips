package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteRespuesta;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.ISoporteRespuestaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ISoporteRespuestaService;

import java.util.List;

@Service
public class SoporteRespuestaImplement implements ISoporteRespuestaService {
    @Autowired
    private ISoporteRespuestaRepository repository;

    @Override
    public List<SoporteRespuesta> listarRespuestas() {
        return repository.findAll();
    }

    @Override
    public SoporteRespuesta obtenerRespuestaPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SoporteRespuesta guardarRespuesta(SoporteRespuesta respuesta) {
        return repository.save(respuesta);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(SoporteRespuesta SoporteRespuesta) {
        repository.save(SoporteRespuesta);

    }

    @Override
    public void insert(SoporteRespuesta SoporteRespuesta) {
        repository.save(SoporteRespuesta);
    }


}

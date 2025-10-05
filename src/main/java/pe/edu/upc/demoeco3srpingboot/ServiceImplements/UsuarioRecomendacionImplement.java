package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Recomendacion;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecomendacion;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUsuarioRecomendacionRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecomendacionService;

import java.util.List;

@Service
public class UsuarioRecomendacionImplement  implements IUsuarioRecomendacionService {

    @Autowired
    private IUsuarioRecomendacionRepository urS;

    @Override
    public List<UsuarioRecomendacion> list() {return urS.findAll();}

    @Override
    public void insert(UsuarioRecomendacion usuarioRecomendacion) {urS.save(usuarioRecomendacion);}

    @Override
    public List<Recomendacion> findRecomendacionesPorUsuario(int idUsuario) {
        return urS.findRecomendacionesPorUsuario(idUsuario);
    }

    @Override
    public void update(UsuarioRecomendacion usuarioRecomendacion) {
        urS.save(usuarioRecomendacion);
    }

    @Override
    public UsuarioRecomendacion listId(int id) {
        return urS.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {urS.deleteById(id);
    }

    @Override
    public List<Recomendacion> filtrarPorTipo(String filtro) {
        return urS.filtrarPorTipo(filtro);
    }

}

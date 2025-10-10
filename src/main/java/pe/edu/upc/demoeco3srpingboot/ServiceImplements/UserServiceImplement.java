package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUserRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUserService;

import java.util.List;


@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uS;

    @Override
    public List<Usuario> list() { return uS.findAll();}

    @Override
    public void insert(Usuario usuario) { uS.save(usuario);}

    @Override
    public Usuario listId(int id) { return uS.findById(id).orElse(null);}

    @Override
    public void delete(int id) { uS.deleteById(id);}

    @Override
    public void update(Usuario usuario) { uS.save(usuario);}

    @Override
    public List<Usuario> buscarR(String Genero) { return uS.buscarR(Genero);}

    @Override
    public List<Object[]> obtenerUsuariosConConteoLogros() {
        return uS.obtenerUsuariosConConteoLogros();
    }

    @Override
    public List<Usuario> findByNivel(int nivel) {
        return uS.findByNivel(nivel);}

    @Override
    public List<Object[]> obtenerDistribucionParticipantesPorGenero() {
        return uS.obtenerDistribucionParticipantesPorGenero();
    }
}
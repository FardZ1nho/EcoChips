package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;
import pe.edu.upc.demoeco3srpingboot.Repositories.IRecompensaRepository;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUserRepository;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUsuarioRecompensaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecompensaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioRecompensaServiceImplement implements IUsuarioRecompensaService {

    @Autowired
    private IUsuarioRecompensaRepository usuarioRecompensaRepository;

    @Autowired
    private IUserRepository usuarioRepository;

    @Autowired
    private IRecompensaRepository recompensaRepository;

    @Override
    public String canjearRecompensa(int idUsuario, int idRecompensa) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        Recompensa recompensa = recompensaRepository.findById(idRecompensa).orElse(null);

        if (usuario == null) {
            return "Usuario no encontrado";
        }
        if (recompensa == null) {
            return "Recompensa no encontrada";
        }

        if (usuario.getCanjesDisponibles() < recompensa.getCostoCanjes()) {
            return "No tienes suficientes canjes para esta recompensa";
        }

        usuario.setCanjesDisponibles(usuario.getCanjesDisponibles() - recompensa.getCostoCanjes());
        usuarioRepository.save(usuario);

        UsuarioRecompensa ur = new UsuarioRecompensa();
        ur.setUsuario(usuario);
        ur.setRecompensa(recompensa);
        ur.setFechaAsignacion(LocalDate.now());
        usuarioRecompensaRepository.save(ur);

        return "Canje realizado con éxito";
    }

    @Override
    public void asignarCanjePorSubirNivel(int idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            usuario.setCanjesDisponibles(usuario.getCanjesDisponibles() + 1);
            usuarioRepository.save(usuario);
        }
    }

    @Override
    public List<UsuarioRecompensa> listar() {
        return usuarioRecompensaRepository.findAll();
    }

    @Override
    public UsuarioRecompensa listarPorId(int id) {
        return usuarioRecompensaRepository.findById(id).orElse(null);
    }

    @Override
    public List<UsuarioRecompensa> listarPorUsuario(int idUsuario) {
        return usuarioRecompensaRepository.listarPorUsuario(idUsuario);
    }

    @Override
    public List<UsuarioRecompensa> listarPorRecompensa(int idRecompensa) {
        return usuarioRecompensaRepository.listarPorRecompensa(idRecompensa);
    }

    @Override
    public void eliminar(int idUsuarioRecompensa) {
        usuarioRecompensaRepository.deleteById(idUsuarioRecompensa);
    }
}

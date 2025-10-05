package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;

import java.util.List;

public interface IUsuarioRecompensaService {
    String canjearRecompensa(int idUsuario, int idRecompensa);
    void asignarCanjePorSubirNivel(int idUsuario);
    List<UsuarioRecompensa> listar();
    UsuarioRecompensa listarPorId(int id);
    List<UsuarioRecompensa> listarPorUsuario(int idUsuario);
    List<UsuarioRecompensa> listarPorRecompensa(int idRecompensa);
    void eliminar(int idUsuarioRecompensa);
}

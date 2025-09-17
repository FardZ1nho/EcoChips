package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;

import java.util.List;

public interface IUsuarioRecompensaService {
    public List<UsuarioRecompensa> list();
    public void insert(UsuarioRecompensa usuariorecompensa);
}

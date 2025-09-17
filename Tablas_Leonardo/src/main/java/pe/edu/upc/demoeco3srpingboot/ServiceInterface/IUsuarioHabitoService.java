package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioHabito;

import java.util.List;

public interface IUsuarioHabitoService {
    public List<UsuarioHabito> list();
    public void insert(UsuarioHabito usuariohabito);
}

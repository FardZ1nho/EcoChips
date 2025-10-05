package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Recomendacion;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecomendacion;

import java.util.List;

public interface IUsuarioRecomendacionService {
    public List<UsuarioRecomendacion> list();
    public void insert(UsuarioRecomendacion usuarioRecomendacion);
    // Nuevo metodo 57
    public List<Recomendacion> findRecomendacionesPorUsuario(int idUsuario);
    public void update(UsuarioRecomendacion usuarioRecomendacion);
    public UsuarioRecomendacion listId(int id);
    public void delete(int id);
    public List<Recomendacion> filtrarPorTipo(String filtro);
}

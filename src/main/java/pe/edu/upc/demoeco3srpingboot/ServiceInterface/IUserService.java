package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.util.List;

public interface IUserService {
    public List<Usuario> list();

    public void insert(Usuario usuario);

    public Usuario listId(int id);

    public void delete(int id);

    public void update(Usuario usuario);

    public List<Usuario> buscarR(String Genero);

    public List<Object[]> obtenerUsuariosConConteoLogros();

    public List<Object[]> obtenerUsuariosConMayorPuntaje();

    public List<Usuario> findByNivel(int nivel);
}
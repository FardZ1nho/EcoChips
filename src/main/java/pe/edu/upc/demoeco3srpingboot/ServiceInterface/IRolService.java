package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();

    public void insert(Rol rol);

    public Rol listId(int id);

    public void delete(int id);

    public void update(Rol rol);

    public List<Rol> buscarR(String nombre);
}

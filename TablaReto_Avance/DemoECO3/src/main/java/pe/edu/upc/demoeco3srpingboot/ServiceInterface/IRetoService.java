package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Reto;

import java.util.List;

public interface IRetoService {
    void insert(Reto reto);
    List<Reto>list();
    void delete(int idReto);
    Reto listId(int idReto);
}

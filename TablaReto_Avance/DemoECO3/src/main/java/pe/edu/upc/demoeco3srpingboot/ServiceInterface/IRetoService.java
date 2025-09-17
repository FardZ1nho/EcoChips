package pe.edu.upc.demoeco3springboot.ServiceInterface;

import pe.edu.upc.demoeco3springboot.Entities.Reto;

import java.util.List;

public interface IRetoService {
    void insert(Reto reto);
    List<Reto>list();
    void delete(Long idReto);
    Reto listId(Long idReto);
}

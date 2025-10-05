package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Recomendacion;

import java.util.List;

public interface IRecomendacionService {
    void insert(Recomendacion recomendacion);
    void delete(int id);
    void update(Recomendacion recomendacion);
    List<Recomendacion> list();
    Recomendacion listId(int id);
}

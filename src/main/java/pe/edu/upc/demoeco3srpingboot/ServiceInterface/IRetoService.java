package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Reto;

import java.time.LocalDate;
import java.util.List;

public interface IRetoService {
    public void insert(Reto reto);
    public List<Reto> list();
    public void update(Reto reto);
    public void delete(int id);
    public Reto listId(int id);
    public int countRetosByFechas(LocalDate fechaInicio, LocalDate fechaFin);
}

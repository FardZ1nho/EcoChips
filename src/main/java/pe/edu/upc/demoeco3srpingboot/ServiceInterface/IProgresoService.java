package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.DTOs.ResumenDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Progreso;

import java.util.List;

public interface IProgresoService {
    List<Progreso> list();
    Progreso listId(int id);
    void insert(Progreso progreso);
    void update(Progreso progreso);
    void delete(int id);
    ResumenDTO obtenerResumen(int idUsuario);
    Progreso completarProgresoYAsignarCanje(int idProgreso);
}

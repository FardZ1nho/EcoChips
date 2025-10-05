package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioEvento;

import java.time.LocalDate;
import java.util.List;

public interface IUsuarioEventoService {

    public List<UsuarioEvento> list();
    public void insert(UsuarioEvento usuarioEvento);
    public void update(UsuarioEvento usuarioEvento);
    public UsuarioEvento listId(int id);
    public void delete(int id);

    long contarEventosEnRango(LocalDate fechaInicio, LocalDate fechaFin);
}
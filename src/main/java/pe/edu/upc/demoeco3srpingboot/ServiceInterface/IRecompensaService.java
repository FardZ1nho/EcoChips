package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;

import java.util.List;

public interface IRecompensaService {

    void insertar(Recompensa recompensa);

    void eliminar(int id);

    void actualizar(Recompensa recompensa);

    List<Recompensa> listar();

    Recompensa listarPorId(int id);

    List<Recompensa> buscarPorCostoCanjesMenorIgual(int canjes);

    List<Recompensa> buscarPorCostoCanjes(int canjes);

    List<Recompensa> buscarPorTitulo(String titulo);
}

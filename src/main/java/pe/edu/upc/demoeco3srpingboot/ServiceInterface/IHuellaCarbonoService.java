package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.HuellaCarbono;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface IHuellaCarbonoService {
    List<HuellaCarbono> list();
    HuellaCarbono listId(int id);
    void insert(HuellaCarbono huella);
    void update(HuellaCarbono huella);
    void delete(int id);

    List<HuellaCarbono> listByUsuario(Usuario usuario);
    List<HuellaCarbono> listByUsuarioAndFechaBetween(Usuario usuario, LocalDate inicio, LocalDate fin);

    Double calcularPromedioCO2(Usuario usuario, LocalDate inicio, LocalDate fin);
    Double calcularPromedioCO2TodosUsuarios(LocalDate inicio, LocalDate fin);
}

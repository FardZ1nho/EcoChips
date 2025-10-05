package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.HuellaCarbono;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.IHuellaCarbonoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IHuellaCarbonoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class HuellaCarbonoServiceImplement implements IHuellaCarbonoService {

    @Autowired
    private IHuellaCarbonoRepository huellaCarbonoRepo;

    @Override
    public List<HuellaCarbono> list() {
        return huellaCarbonoRepo.findAll();
    }

    @Override
    public HuellaCarbono listId(int id) {
        return huellaCarbonoRepo.findById(id).orElse(null);
    }

    @Override
    public void insert(HuellaCarbono huella) {
        huellaCarbonoRepo.save(huella);
    }

    @Override
    public void update(HuellaCarbono huella) {
        huellaCarbonoRepo.save(huella);
    }

    @Override
    public void delete(int id) {
        huellaCarbonoRepo.deleteById(id);
    }

    @Override
    public List<HuellaCarbono> listByUsuario(Usuario usuario) {
        return huellaCarbonoRepo.findByUsuario(usuario);
    }

    @Override
    public List<HuellaCarbono> listByUsuarioAndFechaBetween(Usuario usuario, LocalDate inicio, LocalDate fin) {
        return huellaCarbonoRepo.findByUsuarioAndFechaBetween(usuario, inicio, fin);
    }

    @Override
    public Double calcularPromedioCO2(Usuario usuario, LocalDate inicio, LocalDate fin) {
        return huellaCarbonoRepo.avgCo2ByUsuarioAndFechaBetween(usuario, inicio, fin);
    }

    @Override
    public Double calcularPromedioCO2TodosUsuarios(LocalDate inicio, LocalDate fin) {
        return huellaCarbonoRepo.avgCo2TodosUsuarios(inicio, fin);
    }

}
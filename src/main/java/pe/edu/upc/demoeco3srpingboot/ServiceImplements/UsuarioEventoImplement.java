package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioEvento;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUsuarioEventoRepositoy;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioEventoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioEventoImplement implements IUsuarioEventoService {

    @Autowired
    private IUsuarioEventoRepositoy ueS;

    @Override
    public List<UsuarioEvento> list() {return ueS.findAll();}

    @Override
    public void insert(UsuarioEvento usuarioEvento) {ueS.save(usuarioEvento);}

    @Override
    public void update(UsuarioEvento usuarioEvento) {
        ueS.save(usuarioEvento);
    }

    @Override
    public UsuarioEvento listId(int id) {
        return ueS.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {ueS.deleteById(id);}

    @Override
    public long contarEventosEnRango(LocalDate fechaInicio, LocalDate fechaFin) {
        return ueS.contarEventosEnRango(fechaInicio, fechaFin);}
}

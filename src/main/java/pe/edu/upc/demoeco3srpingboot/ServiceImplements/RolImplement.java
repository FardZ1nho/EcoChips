package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Rol;
import pe.edu.upc.demoeco3srpingboot.Repositories.IRolRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IRolService;

import java.util.List;

@Service
public class RolImplement implements IRolService {
    @Autowired
    private IRolRepository rS;

    @Override
    public List<Rol> list() { return rS.findAll();}

    @Override
    public void insert(Rol rol) { rS.save(rol);}

    @Override
    public Rol listId(int id) { return rS.findById(id).orElse(null);}

    @Override
    public void delete(int id) { rS.deleteById(id);}

    @Override
    public void update(Rol rol) { rS.save(rol);}

    @Override
    public List<Rol> buscarR(String nombre) { return rS.buscarR(nombre);}

}

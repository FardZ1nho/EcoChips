package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioHabito;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUsuarioHabitoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioHabitoService;

import java.util.List;

@Service
public class UsuarioHabitoServiceImplement implements IUsuarioHabitoService {
    @Autowired
    private IUsuarioHabitoRepository uhS;

    @Override
    public List<UsuarioHabito> list() {return uhS.findAll();}

    @Override
    public void insert(UsuarioHabito usuariohabito) {uhS.save(usuariohabito);}
}

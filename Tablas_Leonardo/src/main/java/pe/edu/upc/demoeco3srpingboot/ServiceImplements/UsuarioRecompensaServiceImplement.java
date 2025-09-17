package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUsuarioRecompensaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecompensaService;

import java.util.List;

@Service
public class UsuarioRecompensaServiceImplement implements IUsuarioRecompensaService {
    @Autowired
    private IUsuarioRecompensaRepository urS;

    @Override
    public List<UsuarioRecompensa> list() {return urS.findAll();}

    @Override
    public void insert(UsuarioRecompensa usuariorecompensa){urS.save(usuariorecompensa);}
}

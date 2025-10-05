package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.Evento;
import pe.edu.upc.demoeco3srpingboot.Repositories.IEventoRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IEventoService;

import java.util.List;

@Service

public class EventoServiceImplement implements IEventoService
{
    @Autowired
    private IEventoRepository eS;

    @Override
    public List<Evento> list() {
        return eS.findAll();
    }

    @Override
    public Evento listId(int id) {
        return eS.findById(id).orElse(null);
    }

    @Override
    public void insert(Evento evento) {
        eS.save(evento);
    }

    @Override
    public void delete(int id) {
        eS.deleteById(id);
    }

    @Override
    public void update(Evento evento) {
        eS.save(evento);
    }



}
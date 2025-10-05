package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteSolicitud;
import pe.edu.upc.demoeco3srpingboot.Repositories.ISoporteSolicitudRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ISoporteSolicitudService;

import java.util.List;

@Service
public class SoporteSolicitudImplement implements ISoporteSolicitudService {
    @Autowired
    private ISoporteSolicitudRepository sR;

    @Override
    public List<SoporteSolicitud> list() {
        return sR.findAll();
    }

    @Override
    public void insert(SoporteSolicitud solicitud) {
        sR.save(solicitud);
    }

    @Override
    public SoporteSolicitud listID(int id) {
        return sR.findById(id).orElse(null);
    }

    @Override
    public void update(SoporteSolicitud solicitud) {
        sR.save(solicitud);
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public List<SoporteSolicitud> buscarSoporteSolicitud(String titulo) {
        return sR.buscarPorTitulo(titulo);
    }

    @Override
    public List<SoporteSolicitud> listarPorEstado(String estado) {return sR.listarPorEstado(estado);}
}
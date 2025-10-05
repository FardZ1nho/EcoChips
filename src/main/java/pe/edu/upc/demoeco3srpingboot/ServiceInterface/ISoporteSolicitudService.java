package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.SoporteSolicitud;

import java.util.List;

public interface ISoporteSolicitudService {
    public List<SoporteSolicitud> list();
    public void insert(SoporteSolicitud solicitud);
    public SoporteSolicitud listID(int id);
    public void update(SoporteSolicitud solicitud);
    public void delete(int id);
    public List<SoporteSolicitud> buscarSoporteSolicitud(String titulo);
    public List<SoporteSolicitud> listarPorEstado(String estado);
}

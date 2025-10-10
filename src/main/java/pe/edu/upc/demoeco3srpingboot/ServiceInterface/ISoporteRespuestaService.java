package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.DTOs.SoporteRespuestaListDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteRespuesta;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.util.List;

public interface ISoporteRespuestaService {
    public List<SoporteRespuesta> listarRespuestas();
    public SoporteRespuesta obtenerRespuestaPorId(int id);
    public SoporteRespuesta guardarRespuesta(SoporteRespuesta respuesta);
    public void delete(int id);
    public void update(SoporteRespuesta SoporteRespuesta);
    public void insert(SoporteRespuesta SoporteRespuesta);
    List<SoporteRespuestaListDTO> listarRespuestasReducidas();




}

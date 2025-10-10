package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.DTOs.SoporteRespuestaListDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteRespuesta;
import pe.edu.upc.demoeco3srpingboot.Repositories.ISoporteRespuestaRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.ISoporteRespuestaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoporteRespuestaImplement implements ISoporteRespuestaService {
    @Autowired
    private ISoporteRespuestaRepository repository;

    @Override
    public List<SoporteRespuesta> listarRespuestas() {
        return repository.findAll();
    }

    @Override
    public SoporteRespuesta obtenerRespuestaPorId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SoporteRespuesta guardarRespuesta(SoporteRespuesta respuesta) {
        return repository.save(respuesta);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(SoporteRespuesta SoporteRespuesta) {
        repository.save(SoporteRespuesta);
    }

    @Override
    public void insert(SoporteRespuesta SoporteRespuesta) {
        repository.save(SoporteRespuesta);
    }

    @Override
    public List<SoporteRespuestaListDTO> listarRespuestasReducidas() {
        return repository.findAll().stream().map(resp -> {
            SoporteRespuestaListDTO dto = new SoporteRespuestaListDTO();

            dto.setIdRespuesta(resp.getIdRespuesta());
            dto.setRespuesta(resp.getRespuesta());
            dto.setFecha(resp.getFecha());

            if (resp.getSolicitud() != null) {
                dto.setTituloSolicitud(resp.getSolicitud().getTitulo());
                dto.setDescripcionSolicitud(resp.getSolicitud().getDescripcion());
                dto.setEstadoSolicitud(resp.getSolicitud().getEstado());

                if (resp.getSolicitud().getUsuario() != null) {
                    dto.setNombreUsuario(resp.getSolicitud().getUsuario().getNombre());
                    dto.setCorreoUsuario(resp.getSolicitud().getUsuario().getCorreo());
                } else {
                    dto.setNombreUsuario("Desconocido");
                    dto.setCorreoUsuario("No disponible");
                }
            } else {
                dto.setTituloSolicitud("Sin solicitud asociada");
                dto.setDescripcionSolicitud("N/A");
                dto.setEstadoSolicitud("N/A");
                dto.setNombreUsuario("Desconocido");
                dto.setCorreoUsuario("No disponible");
            }

            return dto;
        }).collect(Collectors.toList());
    }
}

package pe.edu.upc.demoeco3srpingboot.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demoeco3srpingboot.DTOs.ResumenDTO;
import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;
import pe.edu.upc.demoeco3srpingboot.Entities.Progreso;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;
import pe.edu.upc.demoeco3srpingboot.Repositories.IActividadRepository;
import pe.edu.upc.demoeco3srpingboot.Repositories.IProgresoRepository;
import pe.edu.upc.demoeco3srpingboot.Repositories.IUserRepository;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IProgresoService;
import pe.edu.upc.demoeco3srpingboot.ServiceInterface.IUsuarioRecompensaService;

import java.util.List;

@Service
public class ProgresoServiceImplement implements IProgresoService {

    @Autowired
    private IProgresoRepository progresoRepo;

    @Autowired
    private IUserRepository usuarioRepo;

    @Autowired
    private IActividadRepository actividadRepo;

    @Autowired
    private IUsuarioRecompensaService usuarioRecompensaService;

    @Override
    public List<Progreso> list() {
        return progresoRepo.findAll();
    }

    @Override
    public Progreso listId(int id) {
        return progresoRepo.findById(id).orElse(null);
    }

    @Override
    public void insert(Progreso progreso) {
        Usuario usuario = usuarioRepo.findById(progreso.getUsuario().getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Actividad actividad = actividadRepo.findById(progreso.getActividad().getIdActividad())
                .orElseThrow(() -> new IllegalArgumentException("Actividad no encontrada"));

        progreso.setUsuario(usuario);
        progreso.setActividad(actividad);

        // Calcular niveles extra por puntos
        int puntosGanados = progreso.getPuntos();
        int nivelesExtra = puntosGanados / 100; // ejemplo: 100 puntos = 1 nivel
        if (nivelesExtra > 0) {
            usuario.setNivel(usuario.getNivel() + nivelesExtra);
            usuario.setCanjesDisponibles(usuario.getCanjesDisponibles() + nivelesExtra);
        }

        usuarioRepo.save(usuario);
        progresoRepo.save(progreso);
    }

    @Override
    public void update(Progreso progreso) {
        progresoRepo.save(progreso);
    }

    @Override
    public void delete(int id) {
        progresoRepo.deleteById(id);
    }

    @Override
    public ResumenDTO obtenerResumen(int idUsuario) {
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return null;
        }

        int puntosTotales = progresoRepo.sumarPuntosPorUsuario(idUsuario);

        int nivel = (puntosTotales / 1000) + 1; // ejemplo: cada 1000 puntos = nivel
        usuario.setNivel(nivel);

        usuarioRepo.save(usuario);

        ResumenDTO dto = new ResumenDTO();
        dto.setNombre(usuario.getNombre());
        dto.setNivel(nivel);
        dto.setPuntos(puntosTotales);

        return dto;
    }

    @Override
    public Progreso completarProgresoYAsignarCanje(int idProgreso) {
        Progreso progreso = progresoRepo.findById(idProgreso).orElse(null);
        if (progreso == null) return null;

        // 1️⃣ Marcar progreso como completado
        progreso.setEstado(true);
        progresoRepo.save(progreso);

        // 2️⃣ Subir nivel del usuario
        Usuario usuario = progreso.getUsuario();
        usuario.setNivel(usuario.getNivel() + 1);

        // 3️⃣ Asignar canje automáticamente
        usuarioRecompensaService.asignarCanjePorSubirNivel(usuario.getIdUsuario());

        // 4️⃣ Guardar cambios en usuario
        usuarioRepo.save(usuario);

        return progreso;
    }
}

package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioHabito;

import java.util.List;

@Repository
public interface IUsuarioHabitoRepository extends JpaRepository<UsuarioHabito,Integer> {
    @Query("SELECT uh.habito FROM UsuarioHabito uh " +
            "WHERE uh.usuario.idUsuario = :idUsuario " +
            "AND uh.cumplido = true")
    List<HabitoEcologico> findHabitosCompletadosPorUsuario(@Param("idUsuario") int idUsuario);
}

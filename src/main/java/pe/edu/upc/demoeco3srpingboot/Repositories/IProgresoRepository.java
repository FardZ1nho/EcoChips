package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.Progreso;

@Repository
public interface IProgresoRepository extends JpaRepository<Progreso, Integer> {
    @Query("SELECT COALESCE(SUM(p.puntos), 0) FROM Progreso p WHERE p.usuario.idUsuario = :idUsuario")
    int sumarPuntosPorUsuario(@Param("idUsuario") int idUsuario);
}

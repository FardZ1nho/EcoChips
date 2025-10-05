package pe.edu.upc.demoeco3srpingboot.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.Recomendacion;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecomendacion;

import java.util.List;

@Repository
public interface IUsuarioRecomendacionRepository extends JpaRepository<UsuarioRecomendacion,Integer> {

    @Query("SELECT ur.recomendacion FROM UsuarioRecomendacion ur " +
            "WHERE ur.usuario.idUsuario = :idUsuario " +
            "ORDER BY ur.fechaAsignacion DESC")
    List<Recomendacion> findRecomendacionesPorUsuario(@Param("idUsuario") int idUsuario);

    @Query("SELECT r FROM Recomendacion r " +
            "WHERE LOWER(r.tipo) LIKE LOWER(CONCAT('%', :filtro, '%'))")
    List<Recomendacion> filtrarPorTipo(@Param("filtro") String filtro);
}

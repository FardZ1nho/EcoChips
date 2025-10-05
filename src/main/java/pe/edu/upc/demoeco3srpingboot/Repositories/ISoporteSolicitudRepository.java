package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteSolicitud;

import java.util.List;

@Repository
public interface ISoporteSolicitudRepository extends JpaRepository<SoporteSolicitud, Integer> {
    @Query("SELECT s FROM SoporteSolicitud s WHERE s.titulo = :titulo")
    List<SoporteSolicitud> buscarPorTitulo(@Param("titulo") String titulo);

    @Query("SELECT s FROM SoporteSolicitud s WHERE s.estado = :estado")
    List<SoporteSolicitud> listarPorEstado(@Param("estado") String estado);
}


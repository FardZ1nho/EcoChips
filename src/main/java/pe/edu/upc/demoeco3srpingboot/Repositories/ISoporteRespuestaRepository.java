package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.SoporteRespuesta;

@Repository
public interface ISoporteRespuestaRepository extends JpaRepository<SoporteRespuesta, Integer> {
}

package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.Notificacion;

@Repository

public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {
}

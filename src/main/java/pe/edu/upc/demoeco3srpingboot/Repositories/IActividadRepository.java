package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.Actividad;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad,Integer> {
}

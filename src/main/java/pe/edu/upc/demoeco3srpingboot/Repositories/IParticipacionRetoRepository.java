package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.ParticipacionReto;

@Repository
public interface IParticipacionRetoRepository extends JpaRepository<ParticipacionReto, Integer> {
}


package pe.edu.upc.demoeco3springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3springboot.Entities.ParticipacionReto;

@Repository
public interface IParticipacionRetoRepository extends JpaRepository<ParticipacionReto, Integer> {
}


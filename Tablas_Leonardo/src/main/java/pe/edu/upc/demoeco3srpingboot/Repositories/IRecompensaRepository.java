package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;

import java.util.List;

@Repository
public interface IRecompensaRepository extends JpaRepository<Recompensa, Integer> {
    List<Recompensa> findByCostoPuntos(int costoPuntos);
    List<Recompensa> findByTituloRecompensa(String tituloRecompensa);
}

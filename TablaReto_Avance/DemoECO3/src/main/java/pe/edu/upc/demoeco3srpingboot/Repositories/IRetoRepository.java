package pe.edu.upc.demoeco3springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3springboot.Entities.Reto;

import java.util.List;

@Repository
public interface IRetoRepository extends JpaRepository<Reto, Long> {
}

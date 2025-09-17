package pe.edu.upc.demoeco3springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3springboot.Entities.TipoReto;

import java.util.List;

@Repository
public interface ITipoRetoRepository extends JpaRepository<TipoReto, Long> {
}

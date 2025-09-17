package pe.edu.upc.demoeco3springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3springboot.Entities.Logro;

@Repository
public interface ILogroRepository extends JpaRepository<Logro, Integer> {
}

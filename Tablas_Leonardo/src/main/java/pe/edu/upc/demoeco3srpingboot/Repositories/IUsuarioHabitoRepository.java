package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioHabito;

@Repository
public interface IUsuarioHabitoRepository extends JpaRepository<UsuarioHabito,Integer> {
}

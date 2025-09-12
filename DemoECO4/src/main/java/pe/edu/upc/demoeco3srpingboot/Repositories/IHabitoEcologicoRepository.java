package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.HabitoEcologico;

import java.util.List;

@Repository
public interface IHabitoEcologicoRepository extends JpaRepository<HabitoEcologico,Integer> {
    @Query("Select h from HabitoEcologico h where h.tituloHabito like %:tituloHabito%")
    public List<HabitoEcologico> buscar(@Param("tituloHabito") String tituloHabito);
}

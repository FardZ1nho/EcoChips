package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demoeco3srpingboot.Entities.HuellaCarbono;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.time.LocalDate;
import java.util.List;

public interface IHuellaCarbonoRepository extends JpaRepository<HuellaCarbono, Integer> {

    List<HuellaCarbono> findByUsuario(Usuario usuario);

    List<HuellaCarbono> findByUsuarioAndFechaBetween(Usuario usuario, LocalDate inicio, LocalDate fin);

    @Query("SELECT AVG(h.valorCO2) FROM HuellaCarbono h WHERE h.usuario = :usuario AND h.fecha BETWEEN :inicio AND :fin")
    Double avgCo2ByUsuarioAndFechaBetween(@Param("usuario") Usuario usuario,
                                          @Param("inicio") LocalDate inicio,
                                          @Param("fin") LocalDate fin);

    @Query("SELECT AVG(h.valorCO2) FROM HuellaCarbono h WHERE h.fecha BETWEEN :inicio AND :fin")
    Double avgCo2TodosUsuarios(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

}

package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioEvento;

import java.time.LocalDate;

@Repository
public interface IUsuarioEventoRepositoy extends JpaRepository<UsuarioEvento,Integer> {

    @Query("SELECT COUNT(ue) FROM UsuarioEvento ue " +
            "WHERE ue.fechaRegistro BETWEEN :fechaInicio AND :fechaFin")
    long contarEventosEnRango(@Param("fechaInicio") LocalDate fechaInicio,
                              @Param("fechaFin") LocalDate fechaFin);
}

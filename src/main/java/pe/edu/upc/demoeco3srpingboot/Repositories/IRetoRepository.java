package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.Reto;

import java.time.LocalDate;

@Repository
public interface IRetoRepository extends JpaRepository<Reto, Integer> {
    @Query("SELECT COUNT(r) " +
            "FROM Reto r " +
            "WHERE r.fechaInicio >= :fechaInicio " +
            "AND r.fechaFin <= :fechaFin")
    int countRetosByFechas(@Param("fechaInicio") LocalDate fechaInicio,
                           @Param("fechaFin") LocalDate fechaFin);
}

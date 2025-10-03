package com.github.fardz1nho.ecochips.repositories;

import com.github.fardz1nho.ecochips.entities.TipoReto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoRetoRepository extends JpaRepository<TipoReto, Integer> {
    @Query(value = "SELECT tr.nombre_tipo_reto, \n" +
            "       COUNT(r.id_reto) AS TotalRetos\n" +
            "FROM tipo_reto tr\n" +
            "LEFT JOIN reto r ON tr.id_tipo_reto = r.id_tipo_reto\n" +
            "GROUP BY tr.nombre_tipo_reto\n" +
            "ORDER BY TotalRetos DESC", nativeQuery = true)
    List<String[]>TiposXretos();
}

package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.demoeco3srpingboot.Entities.Usuario;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Integer> {
    @Query("select  use from Usuario use where use.genero like %:genero%")
    public List<Usuario> buscarR(@Param("genero") String genero);

    public Usuario findOneByNombre(String nombre);

    @Query("SELECT u FROM Usuario u WHERE u.nivel = :nivel")
    List<Usuario> findByNivel(int nivel);

    @Query(value = "SELECT u.nombre, COUNT(l.id_logro) " +
            "FROM usuario u " +
            "INNER JOIN logro l ON u.id_usuario = l.id_usuario " +
            "GROUP BY u.id_usuario, u.nombre " +
            "ORDER BY COUNT(l.id_logro) DESC",
            nativeQuery = true)
    public List<Object[]> obtenerUsuariosConConteoLogros();

}

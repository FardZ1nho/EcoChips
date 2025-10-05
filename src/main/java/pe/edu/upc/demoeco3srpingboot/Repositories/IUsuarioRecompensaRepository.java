package pe.edu.upc.demoeco3srpingboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demoeco3srpingboot.Entities.Recompensa;
import pe.edu.upc.demoeco3srpingboot.Entities.UsuarioRecompensa;

import java.util.List;

@Repository
public interface IUsuarioRecompensaRepository extends JpaRepository<UsuarioRecompensa, Integer> {

    @Query("SELECT ur FROM UsuarioRecompensa ur WHERE ur.usuario.idUsuario = :idUsuario")
    List<UsuarioRecompensa> listarPorUsuario(int idUsuario);

    @Query("SELECT ur FROM UsuarioRecompensa ur WHERE ur.recompensa.idRecompensa = :idRecompensa")
    List<UsuarioRecompensa> listarPorRecompensa(int idRecompensa);
}

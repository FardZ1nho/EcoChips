package com.github.fardz1nho.ecochips.repositories;

import com.github.fardz1nho.ecochips.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Integer> {
    @Query("select  use from Usuario use where use.genero like %:genero%")
    public List<Usuario> buscarR(@Param("genero") String genero);
}

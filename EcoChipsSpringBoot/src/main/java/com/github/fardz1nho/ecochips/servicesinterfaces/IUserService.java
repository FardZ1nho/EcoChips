package com.github.fardz1nho.ecochips.servicesinterfaces;

import com.github.fardz1nho.ecochips.entities.Usuario;

import java.util.List;

public interface IUserService {
    List<Usuario> list();

    void insert(Usuario usuario);

    Usuario listId(int id);

    void delete(int id);

    void update(Usuario usuario);

    List<Usuario> buscarR(String Genero);
}

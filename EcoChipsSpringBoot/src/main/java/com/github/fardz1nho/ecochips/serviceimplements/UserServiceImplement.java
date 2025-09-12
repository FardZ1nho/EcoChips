package com.github.fardz1nho.ecochips.serviceimplements;

import com.github.fardz1nho.ecochips.entities.Usuario;
import com.github.fardz1nho.ecochips.repositories.IUserRepository;
import com.github.fardz1nho.ecochips.servicesinterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uS;

    @Override
    public List<Usuario> list() { return uS.findAll();}

    @Override
    public void insert(Usuario usuario) { uS.save(usuario);}

    @Override
    public Usuario listId(int id) { return uS.findById(id).orElse(null);}

    @Override
    public void delete(int id) { uS.deleteById(id);}

    @Override
    public void update(Usuario usuario) { uS.save(usuario);}

    @Override
    public List<Usuario> buscarR(String Genero) { return uS.buscarR(Genero);}
}

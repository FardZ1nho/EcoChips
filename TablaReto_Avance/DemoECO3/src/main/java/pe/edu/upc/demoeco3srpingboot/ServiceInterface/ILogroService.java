package com.github.fardz1nho.ecochips.servicesinterfaces;


import com.github.fardz1nho.ecochips.entities.Logro;

import java.util.List;

public interface ILogroService {
    public void insert(Logro logro);
    public List<Logro> list();
    public void delete(int id);
    public Logro listId(int id);
    void update(Logro logro);
}

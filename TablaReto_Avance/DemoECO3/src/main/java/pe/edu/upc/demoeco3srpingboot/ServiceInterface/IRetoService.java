package com.github.fardz1nho.ecochips.servicesinterfaces;


import com.github.fardz1nho.ecochips.entities.Reto;

import java.time.LocalDate;
import java.util.List;

public interface IRetoService {
    public void insert(Reto reto);
    public List<Reto>list();
    public void update(Reto reto);
    public void delete(int id);
    public Reto listId(int id);
    public int countRetosByFechas(LocalDate fechaInicio, LocalDate fechaFin);
}

package com.github.fardz1nho.ecochips.serviceimplements;

import com.github.fardz1nho.ecochips.entities.Reto;
import com.github.fardz1nho.ecochips.repositories.IRetoRepository;
import com.github.fardz1nho.ecochips.servicesinterfaces.IRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class RetoServiceImplement implements IRetoService {
    @Autowired
    private IRetoRepository rRepo;

    @Override
    public void insert(Reto reto){
        rRepo.save(reto);
    }

    @Override
    public List<Reto> list(){
        return rRepo.findAll();
    }

    @Override
    public void update(Reto reto) {
        rRepo.save(reto);
    }

    @Override
    public void delete(int id){
        rRepo.deleteById(id);
    }

    @Override
    public Reto listId(int id){
        return rRepo.findById(id).orElse(new Reto());
    }

    @Override
    public int countRetosByFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return rRepo.countRetosByFechas(fechaInicio, fechaFin);
    }
}

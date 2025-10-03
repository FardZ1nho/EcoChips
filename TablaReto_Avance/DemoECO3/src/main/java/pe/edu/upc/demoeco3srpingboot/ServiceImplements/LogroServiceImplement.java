package com.github.fardz1nho.ecochips.serviceimplements;

import com.github.fardz1nho.ecochips.entities.Logro;
import com.github.fardz1nho.ecochips.repositories.ILogroRepository;
import com.github.fardz1nho.ecochips.servicesinterfaces.ILogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogroServiceImplement implements ILogroService {
    @Autowired
    private ILogroRepository lRepo;

    @Override
    public void insert(Logro logro){
        lRepo.save(logro);
    }

    @Override
    public List<Logro>list(){
        return lRepo.findAll();
    }

    @Override
    public void delete(int id){
        lRepo.deleteById(id);
    }

    @Override
    public Logro listId(int id){
        return lRepo.findById(id).orElse(new Logro());
    }

    @Override
    public void update(Logro logro) {
        lRepo.save(logro);
    }
}

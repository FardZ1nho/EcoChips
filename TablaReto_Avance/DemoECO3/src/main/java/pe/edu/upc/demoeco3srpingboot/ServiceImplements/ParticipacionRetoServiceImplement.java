package com.github.fardz1nho.ecochips.serviceimplements;

import com.github.fardz1nho.ecochips.entities.ParticipacionReto;
import com.github.fardz1nho.ecochips.repositories.IParticipacionRetoRepository;
import com.github.fardz1nho.ecochips.servicesinterfaces.IParticipacionRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ParticipacionRetoServiceImplement implements IParticipacionRetoService {
    @Autowired
    private IParticipacionRetoRepository prRepo;

    @Override
    public List<ParticipacionReto>list(){
        return prRepo.findAll();
    }

    @Override
    public ParticipacionReto listId(int id){
        return prRepo.findById(id).orElse(new ParticipacionReto());
    }

    @Override
    public void insert(ParticipacionReto participacionReto){
        prRepo.save(participacionReto);
    }

    @Override
    public void update(ParticipacionReto participacionReto) {
        prRepo.save(participacionReto);
    }

    @Override
    public void delete(int id) {
        prRepo.deleteById(id);
    }
}

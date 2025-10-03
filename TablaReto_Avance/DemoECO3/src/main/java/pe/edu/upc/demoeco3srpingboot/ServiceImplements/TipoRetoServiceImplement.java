package com.github.fardz1nho.ecochips.serviceimplements;

import com.github.fardz1nho.ecochips.entities.TipoReto;
import com.github.fardz1nho.ecochips.repositories.ITipoRetoRepository;
import com.github.fardz1nho.ecochips.servicesinterfaces.ITipoRetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TipoRetoServiceImplement implements ITipoRetoService {
    @Autowired
    private ITipoRetoRepository tRepo;

    @Override
    public void insert(TipoReto tipoReto) {
        tRepo.save(tipoReto);
    }

    @Override
    public List<TipoReto>list(){
        return tRepo.findAll();
    }

    @Override
    public void update(TipoReto tipoReto) {
        tRepo.save(tipoReto);
    }

    @Override
    public void delete(int id){
        tRepo.deleteById(id);
    }

    @Override
    public TipoReto listId(int id){
        return tRepo.findById(id).orElse(new TipoReto());
    }

    @Override
    public List<String[]> TiposXretos(){
        return tRepo.TiposXretos();
    }
}

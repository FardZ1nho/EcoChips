package com.github.fardz1nho.ecochips.servicesinterfaces;


import com.github.fardz1nho.ecochips.entities.ParticipacionReto;

import java.util.List;

public interface IParticipacionRetoService {
    public List<ParticipacionReto> list();
    public void insert(ParticipacionReto participacionReto);
    public void update(ParticipacionReto participacionReto);
    public ParticipacionReto listId(int id);
    public void delete(int id);
}

package com.github.fardz1nho.ecochips.servicesinterfaces;


import com.github.fardz1nho.ecochips.entities.TipoReto;

import java.util.List;

public interface ITipoRetoService {
    public void insert(TipoReto tipoReto);
    public List<TipoReto> list();
    public void update(TipoReto tipoReto);
    public void delete(int id);
    public TipoReto listId(int id);
    public List<String[]> TiposXretos();
}

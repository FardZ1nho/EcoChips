package pe.edu.upc.demoeco3srpingboot.ServiceInterface;

import pe.edu.upc.demoeco3srpingboot.Entities.Logro;

import java.util.List;

public interface ILogroService {
    public void insert(Logro logro);
    public List<Logro> list();
    public void delete(int id);
    public void update(Logro logro);
    public Logro listId(int id);
}

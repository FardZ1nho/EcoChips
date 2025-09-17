package pe.edu.upc.demoeco3springboot.ServiceInterface;

import pe.edu.upc.demoeco3springboot.Entities.Logro;

import java.util.List;

public interface ILogroService {
    public void insert(Logro logro);
    public List<Logro> list();
    public void delete(int idLogro);
    public Logro listId(int idLogro);
}

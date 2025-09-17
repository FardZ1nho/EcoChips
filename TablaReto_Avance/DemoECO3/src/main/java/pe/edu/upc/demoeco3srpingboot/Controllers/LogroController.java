package pe.edu.upc.demoeco3springboot.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoeco3springboot.Entities.Logro;
import pe.edu.upc.demoeco3springboot.ServiceInterface.ILogroService;

import java.util.List;

@RestController
@RequestMapping("/logros")
public class LogroController {
    @Autowired
    private ILogroService lService;

    @PostMapping
    public void insertar(@RequestBody Logro logro) {
        lService.insert(logro);
    }

    @GetMapping
    public List<Logro> listar() {
        return lService.list();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        lService.delete(id);
    }

    @GetMapping("/{id}")
    public Logro listarId(@PathVariable("id") Integer id) {
        return lService.listId(id);
    }
}

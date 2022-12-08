package cl.tbdlab.voluntariadoGrupo1.servicesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ServiceVoluntario {
    private final VoluntarioRepository voluntarioRepository;

    ServiceVoluntario(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @RequestMapping(value = "/voluntariosMongo", method = RequestMethod.GET)
    public List<Voluntario> getAllVoluntario() {
        return voluntarioRepository.findAll();
    }

    @RequestMapping(value = "/voluntariosMongo/{id}", method = RequestMethod.PUT)
    public void updateVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioRepository.save(voluntario);
    }

    @RequestMapping(value = "/voluntariosMongo", method = RequestMethod.POST)
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    @DeleteMapping(value = "/voluntariosMongo/{id}")
    public void eliminar(@PathVariable(value = "id") int id) {
        voluntarioRepository.deleteById(id);;
    }
}

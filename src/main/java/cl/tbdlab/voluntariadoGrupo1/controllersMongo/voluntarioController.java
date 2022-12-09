package cl.tbdlab.voluntariadoGrupo1.controllersMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.VoluntarioRepository;
import cl.tbdlab.voluntariadoGrupo1.servicesMongo.ServiceVoluntario;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class voluntarioController {

    private final ServiceVoluntario serviceVoluntario;
    private final VoluntarioRepository voluntarioRepository;

    public voluntarioController(ServiceVoluntario serviceVoluntario, VoluntarioRepository voluntarioRepository){
        this.serviceVoluntario = serviceVoluntario;
        this.voluntarioRepository = voluntarioRepository;
    }
    @RequestMapping(value = "/voluntariosMongo", method = RequestMethod.GET)
    public List<Voluntario> getAllVoluntario() {
        return voluntarioRepository.findAll();
    }

    @RequestMapping(value = "/testmongo", method = RequestMethod.GET)
    public void test(){
        serviceVoluntario.test();
    }

    @RequestMapping(value = "/voluntariosMongo/{id}", method = RequestMethod.PUT)
    public void updateVoluntario(@RequestBody Voluntario voluntario) {
        voluntarioRepository.save(voluntario);
    }

    @RequestMapping(value = "/voluntariosMongo", method = RequestMethod.POST)
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario) {
        return voluntarioRepository.insert(voluntario);
    }

    @DeleteMapping(value = "/voluntariosMongo/{id}")
    public void eliminar(@PathVariable(value = "id") int id) {
        voluntarioRepository.deleteById(id);;
    }
}

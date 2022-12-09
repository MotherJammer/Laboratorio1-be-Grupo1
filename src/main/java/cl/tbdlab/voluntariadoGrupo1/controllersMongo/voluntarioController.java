package cl.tbdlab.voluntariadoGrupo1.controllersMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Comuna;
import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Promedio;
import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.ComunaRepository;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.VoluntarioRepository;
import cl.tbdlab.voluntariadoGrupo1.servicesMongo.PromedioService;
import cl.tbdlab.voluntariadoGrupo1.servicesMongo.ServiceVoluntario;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class voluntarioController {

    private final ServiceVoluntario serviceVoluntario;
    private final PromedioService promedioService;
    private final VoluntarioRepository voluntarioRepository;
    private final ComunaRepository comunaRepository;

    public voluntarioController(ServiceVoluntario serviceVoluntario, VoluntarioRepository voluntarioRepository, ComunaRepository comunaRepository, PromedioService promedioService){
        this.serviceVoluntario = serviceVoluntario;
        this.voluntarioRepository = voluntarioRepository;
        this.comunaRepository = comunaRepository;
        this.promedioService = promedioService;
    }
    @RequestMapping(value = "/voluntariosMongo", method = RequestMethod.GET)
    public List<Voluntario> getAllVoluntario() {
        return voluntarioRepository.findAll();
    }

    @RequestMapping(value = "/promedio", method = RequestMethod.GET)
    public List<Promedio> test(){
        List<Comuna> abc = comunaRepository.resultado();
        List<Promedio> cba = promedioService.promediosComuna(abc);

        return cba;
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

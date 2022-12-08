package cl.tbdlab.voluntariadoGrupo1.servicesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Emergencia;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ServiceEmergencia {
    private final EmergenciaRepository emergenciaRepository;

    ServiceEmergencia(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    @RequestMapping(value = "/emergenciasMongo", method = RequestMethod.GET)
    public List<Emergencia> getAllEmergency() {
        return emergenciaRepository.findAll();
    }

    @RequestMapping(value = "/emergenciasMongo/{id}", method = RequestMethod.PUT)
    public void updateEmergency(@RequestBody Emergencia emergencia) {
        emergenciaRepository.save(emergencia);
    }

    @RequestMapping(value = "/emergenciasMongo", method = RequestMethod.POST)
    public Emergencia createEmergency(@RequestBody Emergencia emergencia) {
        return emergenciaRepository.save(emergencia);
    }

    @DeleteMapping(value = "/emergenciasMongo/{id}")
    public void eliminar(@PathVariable(value = "id") int id) {
        emergenciaRepository.deleteById(id);;
    }
}

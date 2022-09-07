package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.Emergencia;
import cl.tbdlab.voluntariadoGrupo1.repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencias/{id}")
    public Emergencia getEmergencia(@PathVariable("id") int id){
        return emergenciaRepository.readEmergencia(id);
    }

    @GetMapping("/emergencias")
    public List<Emergencia> getEmergencia(){
        return emergenciaRepository.readEmergencia();
    }

    @PostMapping("/emergencias")
    @ResponseBody
    public int createEmergencia(@RequestBody Emergencia emergencia){
        return emergenciaRepository.insertEmergencia(emergencia);
    }

    @PutMapping("/emergencias/{id}")
    public int updateEmergencia(@PathVariable("id") int id, @RequestBody Emergencia emergencia){
        emergencia.setId(String.valueOf(id));
        return emergenciaRepository.updateEmergencia(emergencia);
    }
    @DeleteMapping("/emergencias")
    public int deleteEmergency(){
        return emergenciaRepository.deleteEmergencia();
    }
    @DeleteMapping("/emergencias/{id}")
    public int deleteEmergency(@PathVariable("id") int id){
        return emergenciaRepository.deleteEmergencia(id);
    }

}

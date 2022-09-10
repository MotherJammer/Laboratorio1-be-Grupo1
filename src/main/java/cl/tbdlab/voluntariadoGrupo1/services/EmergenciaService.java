package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.Emergencia;
import cl.tbdlab.voluntariadoGrupo1.repositories.EmergenciaRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.catalina.connector.Request;
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
    public Emergencia getEmergencia(@PathVariable("id") Long id){
        return emergenciaRepository.readEmergencia(id);
    }

    @GetMapping("/emergencias")
    public List<Emergencia> getEmergencia(){
        return emergenciaRepository.readEmergencia();
    }

    @PostMapping("/emergencias")
    public int createEmergencia(@RequestBody Emergencia e){
        return emergenciaRepository.insertEmergencia(e);
    }

    @PutMapping("/emergencias/{id}")
    public int updateEmergencia(@PathVariable("id") Long id, @RequestBody Emergencia emergencia){
        emergencia.setId(id);
        return emergenciaRepository.updateEmergencia(emergencia, id);
    }
    @DeleteMapping("/emergencias")
    public int deleteEmergency(){
        return emergenciaRepository.deleteEmergencia();
    }
    @DeleteMapping("/emergencias/{id}")
    public int deleteEmergency(@PathVariable("id") Long id){
        return emergenciaRepository.deleteEmergencia(id);
    }

}

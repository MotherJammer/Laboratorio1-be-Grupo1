package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.EmergenciaRepository;
import cl.tbdlab.voluntariadoGrupo1.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {
    private final EmergenciaRepository emergenciaRepository;
    private final InstitucionRepository institucionRepository;
    EmergenciaService(EmergenciaRepository emergenciaRepository, InstitucionRepository institucionRepository){
        this.emergenciaRepository = emergenciaRepository;
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/emergencias/{id}")
    public EmergenciaModel getEmergencia(@PathVariable("id") Long id){
        return emergenciaRepository.readEmergencia(id);
    }

    @GetMapping("/emergencias")
    public List<EmergenciaModel> getEmergencia(){
        return emergenciaRepository.readEmergencia();
    }


    @PostMapping("/emergencias")
    public  int testCreateEmergencia (String nombre, String estado_eme, String detalles, int voluntarios_reg, Long id_in){
        return emergenciaRepository.insertEmergencia(nombre,estado_eme,detalles,voluntarios_reg, id_in);
    }

    @PutMapping("/emergencias/{id}")
    public int updateEmergencia(@PathVariable("id") Long id, @RequestBody EmergenciaModel emergencia){
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

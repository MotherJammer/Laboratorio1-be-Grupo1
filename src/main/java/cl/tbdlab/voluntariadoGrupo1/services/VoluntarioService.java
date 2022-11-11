package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.EmergenciaModel;
import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.EmergenciaRepository;
import cl.tbdlab.voluntariadoGrupo1.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioService {

    @Autowired
    private final VoluntarioRepository voluntarioRepository;

    @Autowired
    EmergenciaRepository emergenciaRepository;


    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @PostMapping("/voluntarios")
    public int createVoluntario(String nombre, Boolean disponibilidad, double longitud, double latitud){
        disponibilidad = true;
        return voluntarioRepository.createVoluntario(nombre, disponibilidad, longitud, latitud);
    }

    @GetMapping("/voluntarios/{id}")
    public VoluntarioModel getVoluntario(@PathVariable("id") int id){
        return voluntarioRepository.readVoluntario(id);
    }

    @GetMapping("/voluntarios")
    public List<VoluntarioModel> getAllVoluntarios(){
        return voluntarioRepository.readAllVoluntarios();
    }

    @PutMapping("/voluntarios/{id}")
    public int updateVoluntario(@PathVariable("id") Long id, @RequestBody VoluntarioModel voluntario){
        voluntario.setId(id);
        return voluntarioRepository.updateVoluntario(voluntario, id);
    }

    @DeleteMapping("/voluntarios/{id}")
    public int deleteVoluntario(@PathVariable ("id") Long id){
        return voluntarioRepository.deleteVoluntario(id);
    }

    @DeleteMapping("/voluntarios")
    public int deleteAllVoluntario(){
        return voluntarioRepository.deleteAllVoluntarios();
    }

    @GetMapping("/voluntarios/closer")
    public int getCloserVoluntarios(Long id_eme, Long cantidad){
        int id_emergencia= id_eme.intValue();
        int cantidadVoluntarios= cantidad.intValue();
        List<VoluntarioModel> voluntariosCercanos = voluntarioRepository.getVoluntariosByEmergencia(id_emergencia);
        EmergenciaModel emergencia = emergenciaRepository.readEmergencia(id_emergencia);
        voluntarioRepository.distanciasVoluntariosEmergencia(voluntariosCercanos, emergencia, cantidadVoluntarios);
        return 1;
    }
}

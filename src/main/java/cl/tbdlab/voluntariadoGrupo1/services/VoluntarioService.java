package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    VoluntarioService(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository = voluntarioRepository;
    }

    @PostMapping("/voluntarios")
    public int createVoluntario(@RequestBody VoluntarioModel voluntario){
        return voluntarioRepository.createVoluntario(voluntario);
    }

    @GetMapping("/voluntarios/{id}")
    public VoluntarioModel getVoluntario(@PathVariable("id") Long id){
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
}

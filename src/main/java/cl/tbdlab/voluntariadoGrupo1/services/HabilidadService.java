package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.HabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.HabilidadRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    @PostMapping("/habilidades")
    public int createHabilidad(@RequestBody HabilidadModel habilidad){
        return habilidadRepository.createHabilidad(habilidad);
    }

    @GetMapping("/habilidades/{id}")
    public HabilidadModel getHabilidad(@PathVariable("id") Long id){
        return habilidadRepository.readHabilidad(id);
    }

    @GetMapping("/habilidades")
    public List<HabilidadModel> getAllHabilidades(){
        return habilidadRepository.readAllHabilidades();
    }

    @PutMapping("/habilidades/{id}")
    public int updateHabilidad(@PathVariable("id") Long id, @RequestBody HabilidadModel habilidad){
        habilidad.setId(id);
        return habilidadRepository.updateHabilidad(habilidad, id);
    }

    @DeleteMapping("/habilidades/{id}")
    public int deleteHabilidad(@PathVariable ("id") Long id){
        return habilidadRepository.deleteHabilidad(id);
    }

    @DeleteMapping("/habilidades")
    public int deleteAllHabilidad(){
        return habilidadRepository.deleteAllHabilidades();
    }

    @PostMapping("/testHabilidades")
    public void idk (@RequestParam List<Integer> idHabilidades){
        habilidadRepository.temporalEme_Habilidad(idHabilidades);
    }

}

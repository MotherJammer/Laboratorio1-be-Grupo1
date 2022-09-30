package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.EmeHabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.InstitucionModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.EmeHabilidadRepository;
import cl.tbdlab.voluntariadoGrupo1.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmeHabilidadService {
    private final EmeHabilidadRepository emeHabilidadRepository;

    EmeHabilidadService(EmeHabilidadRepository emeHabilidadRepository){
        this.emeHabilidadRepository = emeHabilidadRepository;
    }

    @PostMapping("/eme_habilidad")
    public int createEmeHabilidad(@RequestParam List<Long> idHabilidades) throws InterruptedException {
        Thread.sleep(5000);
        return emeHabilidadRepository.createEmeHabilidad(idHabilidades);
    }

    @GetMapping("/eme_habilidad/{id}")
    public EmeHabilidadModel getEmeHabilidad(@PathVariable("id") Long id){
        return emeHabilidadRepository.readEmeHabilidad(id);
    }

    @GetMapping("/eme_habilidad")
    public List<EmeHabilidadModel> getAllEmeHabilidad(){
        return emeHabilidadRepository.readAllEmeHabilidad();
    }

    @PutMapping("/eme_habilidad/{id}")
    public int updateEmeHabilidad(@PathVariable("id") Long id, @RequestBody EmeHabilidadModel emeHabilidad){
        emeHabilidad.setId(id);
        return emeHabilidadRepository.updateEmeHabilidad(emeHabilidad, id);
    }

    @DeleteMapping("/eme_habilidad/{id}")
    public int deleteEmeHabilidad(@PathVariable ("id") Long id){
        return emeHabilidadRepository.deleteEmeHabilidad(id);
    }

    @DeleteMapping("/eme_habilidad")
    public int deleteAllInstituciones(){
        return emeHabilidadRepository.deleteAllEmeHabilidad();
    }

}
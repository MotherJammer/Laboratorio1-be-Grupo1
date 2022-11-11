package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.HabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.VolHabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.VoluntarioModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.HabilidadRepository;
import cl.tbdlab.voluntariadoGrupo1.repositories.VolHabilidadRepository;
import cl.tbdlab.voluntariadoGrupo1.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VolHabilidadService {
    private final VolHabilidadRepository volHabilidadRepository;
    public VolHabilidadService(VolHabilidadRepository volHabilidadRepository) {this.volHabilidadRepository = volHabilidadRepository;}

    @PostMapping("/vol_ha")
    public int createVoluntario(@RequestParam List<Long> idHabilidades) throws InterruptedException{
        Thread.sleep(5000);
        return volHabilidadRepository.createVolHabilidad(idHabilidades);
    }

    @GetMapping("/vol_ha/{id}")
    public VolHabilidadModel getVoluntario(@PathVariable("id") Long id){
        return volHabilidadRepository.readVolHabilidad(id);
    }

    @GetMapping("/vol_ha")
    public List<VolHabilidadModel> getAllVoluntarios(){
        return volHabilidadRepository.readAllVolHabilidad();
    }

    @PutMapping("/vol_ha/{id}")
    public int updateVoluntario(@PathVariable("id") Long id, @RequestBody VolHabilidadModel voluntario){
        voluntario.setId(id);
        return volHabilidadRepository.updateVolHabilidad(voluntario, id);
    }

    @DeleteMapping("/vol_ha/{id}")
    public int deleteVoluntario(@PathVariable ("id") Long id){
        return volHabilidadRepository.deleteVolHabilidad(id);
    }

    @DeleteMapping("/vol_ha")
    public int deleteAllVoluntario(){
        return volHabilidadRepository.deleteAllVolHabilidad();
    }
}

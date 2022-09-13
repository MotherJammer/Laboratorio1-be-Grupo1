package cl.tbdlab.voluntariadoGrupo1.services;

import cl.tbdlab.voluntariadoGrupo1.models.HabilidadModel;
import cl.tbdlab.voluntariadoGrupo1.models.InstitucionModel;
import cl.tbdlab.voluntariadoGrupo1.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @PostMapping("/instituciones")
    public int createInstitucion(@RequestBody InstitucionModel institucion){
        return institucionRepository.createInstitucion(institucion);
    }

    @GetMapping("/instituciones/{id}")
    public InstitucionModel getInstitucion(@PathVariable("id") Long id){
        return institucionRepository.readInstitucion(id);
    }

    @GetMapping("/instituciones")
    public List<InstitucionModel> getAllInstituciones(){
        return institucionRepository.readAllInstituciones();
    }

    @PutMapping("/instituciones/{id}")
    public int updateInstitucion(@PathVariable("id") Long id, @RequestBody InstitucionModel institucion){
        institucion.setId(id);
        return institucionRepository.updateInstitucion(institucion, id);
    }

    @DeleteMapping("/instituciones/{id}")
    public int deleteInstitucion(@PathVariable ("id") Long id){
        return institucionRepository.deleteInstitucion(id);
    }

    @DeleteMapping("/instituciones")
    public int deleteAllInstituciones(){
        return institucionRepository.deleteAllInstituciones();
    }
}

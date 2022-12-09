package cl.tbdlab.voluntariadoGrupo1.servicesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ServiceVoluntario {

    private final VoluntarioRepository voluntarioRepository;

    public  ServiceVoluntario(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository= voluntarioRepository;
    }

    public void test(){
        List<Voluntario> a = voluntarioRepository.findAll();

        for (int i=0; i < a.size();i++){
            System.out.println(a.get(i).getComuna());
        }
    }


}

package cl.tbdlab.voluntariadoGrupo1.repositoriesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoluntarioRepository extends MongoRepository<Voluntario, Integer>{


}

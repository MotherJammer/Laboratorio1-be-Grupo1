package cl.tbdlab.voluntariadoGrupo1.repositoriesMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Emergencia;

public interface EmergenciaRepository extends MongoRepository<Emergencia, Integer>{
}

package cl.tbdlab.voluntariadoGrupo1.repositoriesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Comuna;
import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VoluntarioRepository extends MongoRepository<Voluntario, Integer>{
    @Query("{point: {$geoWithin: {$center: [[?2, ?1], ?0]}}}")
    List<Voluntario> getVoluntariosInRadius(int radio, double x, double y);
}

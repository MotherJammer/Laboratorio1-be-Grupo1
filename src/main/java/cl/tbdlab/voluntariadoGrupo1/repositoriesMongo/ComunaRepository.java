package cl.tbdlab.voluntariadoGrupo1.repositoriesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Comuna;
import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComunaRepository extends MongoRepository<Voluntario, String> {


    /*@Aggregation(pipeline = {"{" +
            "    \"$group\": {" +
            "      _id: \"$comuna\",\n" +
            "      habilidades: {\n" +
            "        $sum: {\n" +
            "          $size: \"$habilidad\"\n" +
            "        }\n" +
            "      },\n" +
            "      personas: {\n" +
            "        $sum: 1\n" +
            "      }\n" +
            "    }\n" +
            "  }"} )
    List<Comuna> resultado();*/

    @Aggregation("{$group: {" +
            "_id: $comuna," +
            "habilidades: {" +
            "$sum: {" +
            "$size:  $habilidad }}," +
            "personas: {" +
            "$sum:  1} } " +
            "}")
    List<Comuna> resultado();

}

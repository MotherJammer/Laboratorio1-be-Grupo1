package cl.tbdlab.voluntariadoGrupo1.servicesMongo;

import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Comuna;
import cl.tbdlab.voluntariadoGrupo1.modelsMongo.Voluntario;
import cl.tbdlab.voluntariadoGrupo1.repositoriesMongo.VoluntarioRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import java.util.Arrays;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ServiceVoluntario {

    private final VoluntarioRepository voluntarioRepository;

    public  ServiceVoluntario(VoluntarioRepository voluntarioRepository){
        this.voluntarioRepository= voluntarioRepository;
    }

    public List<Voluntario> getVoluntariosInRadio(int radio, double x, double y){
        return voluntarioRepository.getVoluntariosInRadius(radio,x,y);
    }
}

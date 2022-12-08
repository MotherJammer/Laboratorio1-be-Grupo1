package cl.tbdlab.voluntariadoGrupo1.modelsMongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Document(collection = "voluntario")
public class Voluntario {
    @Id private BigInteger id;
    private String nombre;
    private Boolean disponibilidad;
    private Point point;
    private List<Habilidad> habilidad;
    private String comuna;
}

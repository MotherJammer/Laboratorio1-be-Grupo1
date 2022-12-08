package cl.tbdlab.voluntariadoGrupo1.modelsMongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigInteger;
import java.util.List;

@Document(collection = "emergencia")
public class Emergencia {
    @Getter @Setter @Id private BigInteger id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String estado_eme;
    @Getter @Setter private String detalles;
    @Getter @Setter private int voluntarios_reg;
    @Getter @Setter private Institucion institucion;
    @Getter @Setter private Point point;
    @Getter @Setter private List<Habilidad> habilidad;
}

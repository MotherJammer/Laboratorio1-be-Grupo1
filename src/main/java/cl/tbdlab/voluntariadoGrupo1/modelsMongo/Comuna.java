package cl.tbdlab.voluntariadoGrupo1.modelsMongo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection="comuna")
@Data
public class Comuna {

    private String _id;
    private int habilidades;
    private int personas;



}

package cl.tbdlab.voluntariadoGrupo1.modelsMongo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Promedio {

    private String comuna;
    private double promedio;

    public Promedio(String comuna, double promedio) {
        this.comuna = comuna;
        this.promedio = promedio;
    }

}

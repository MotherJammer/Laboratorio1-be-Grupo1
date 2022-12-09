package cl.tbdlab.voluntariadoGrupo1.modelsMongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromedioModel {

    private String comuna;

    private double promedio;
    public PromedioModel(String comuna, double promedio) {
        this.comuna = comuna;
        this.promedio = promedio;
    }



}

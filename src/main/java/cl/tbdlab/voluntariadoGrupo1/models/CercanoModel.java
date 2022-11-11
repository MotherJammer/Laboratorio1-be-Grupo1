package cl.tbdlab.voluntariadoGrupo1.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CercanoModel {

    private String nombreVoluntario;
    private double distancia;

    public CercanoModel(String nombreVoluntario, double distancia) {
        this.nombreVoluntario = nombreVoluntario;
        this.distancia = distancia;
    }
}

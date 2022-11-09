package cl.tbdlab.voluntariadoGrupo1.models;

import lombok.Getter;
import lombok.Setter;

public class FinishedEmergencyModel {
    @Getter @Setter long id;
    @Getter @Setter String nombre;
    @Getter @Setter int vol_reg;
    @Getter @Setter int tareas;
}

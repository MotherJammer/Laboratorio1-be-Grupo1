package cl.tbdlab.voluntariadoGrupo1.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emergencia {
    @Getter @Setter @Id String id;
    @Getter @Setter String nombre;
    @Getter @Setter String estado_eme;
    @Getter @Setter String detalles;
    @Getter @Setter String voluntarios_reg;
    @Getter @Setter String id_in;
}

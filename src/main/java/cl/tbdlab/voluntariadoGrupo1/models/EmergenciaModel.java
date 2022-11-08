package cl.tbdlab.voluntariadoGrupo1.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
public class EmergenciaModel {
    @Getter @Setter @Id Long id;
    @Getter @Setter String nombre;
    @Getter @Setter String estado_eme;
    @Getter @Setter String detalles;
    @Getter @Setter int voluntarios_reg;
    @Getter @Setter Long id_in;
    @Getter @Setter double longitud;
    @Getter @Setter double latitud;
}

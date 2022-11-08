package cl.tbdlab.voluntariadoGrupo1.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class VoluntarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private Boolean disponibilidad;
    private double longitud;
    private double latitud;
}

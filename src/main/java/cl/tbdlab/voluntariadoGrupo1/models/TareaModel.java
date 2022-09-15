package cl.tbdlab.voluntariadoGrupo1.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TareaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;

    private Long id_es;
    private Long id_em;
}

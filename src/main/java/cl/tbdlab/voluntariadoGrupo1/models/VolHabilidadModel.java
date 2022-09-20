package cl.tbdlab.voluntariadoGrupo1.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VolHabilidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Long id_vo;
    private Long id_ha;
}

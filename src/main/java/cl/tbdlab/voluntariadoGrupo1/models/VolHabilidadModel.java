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

    @ManyToOne
    @JoinColumn(name = "Voluntario")
    VoluntarioModel voluntario;

    @ManyToOne
    @JoinColumn(name = "Habilidad")
    HabilidadModel habilidad;

    public VolHabilidadModel(VoluntarioModel voluntario, HabilidadModel habilidad) {
        this.voluntario = voluntario;
        this.habilidad = habilidad;
    }

    public VolHabilidadModel() {
    }
}

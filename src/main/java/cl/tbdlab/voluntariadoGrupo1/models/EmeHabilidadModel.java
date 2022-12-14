package cl.tbdlab.voluntariadoGrupo1.models;

import javax.persistence.*;

@Entity
public class EmeHabilidadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Emergencia")
    EmergenciaModel emergencia;

    @ManyToOne
    @JoinColumn(name = "Habilidad")
    HabilidadModel habilidadModel;

    public EmeHabilidadModel(EmergenciaModel emergencia, HabilidadModel habilidadModel) {
        this.emergencia = emergencia;
        this.habilidadModel = habilidadModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmergenciaModel getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(EmergenciaModel emergencia) {
        this.emergencia = emergencia;
    }

    public HabilidadModel getHabilidadModel() {
        return habilidadModel;
    }

    public void setHabilidadModel(HabilidadModel habilidadModel) {
        this.habilidadModel = habilidadModel;
    }

    public EmeHabilidadModel() {
    }
}

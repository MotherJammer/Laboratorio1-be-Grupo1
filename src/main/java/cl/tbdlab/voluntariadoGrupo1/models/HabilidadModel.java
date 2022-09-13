package cl.tbdlab.voluntariadoGrupo1.models;

import javax.persistence.*;

@Entity
public class HabilidadModel {

    // Atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;

    // Métodos

    public HabilidadModel(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public HabilidadModel() {
    }
}

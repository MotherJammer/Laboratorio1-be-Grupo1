package cl.tbdlab.voluntariadoGrupo1.models;

import javax.persistence.*;

@Entity
public class InstitucionModel {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String coordinador;

    // Métodos

    public InstitucionModel(Long id, String nombre, String coordinador) {
        this.id = id;
        this.nombre = nombre;
        this.coordinador = coordinador;
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

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }
    public InstitucionModel() {
    }
}

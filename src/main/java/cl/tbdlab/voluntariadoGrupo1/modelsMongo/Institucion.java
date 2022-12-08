package cl.tbdlab.voluntariadoGrupo1.modelsMongo;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private BigInteger id;
    private String nombre;
    private String coordinador;

    public Institucion(BigInteger id, String nombre, String coordinador) {
        this.id = id;
        this.nombre = nombre;
        this.coordinador = coordinador;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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
    public Institucion() {
    }
}

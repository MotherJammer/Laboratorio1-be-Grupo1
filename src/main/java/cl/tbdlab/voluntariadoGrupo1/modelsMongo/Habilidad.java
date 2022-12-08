package cl.tbdlab.voluntariadoGrupo1.modelsMongo;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private BigInteger id;
    private String nombre;
    private String descripcion;
    private String codigo;

    public Habilidad(BigInteger id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
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
    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String nombre) {
        this.nombre = codigo;
    }
    public Habilidad() {
    }
}

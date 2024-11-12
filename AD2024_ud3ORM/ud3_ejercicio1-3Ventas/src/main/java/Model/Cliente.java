package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    private String poblacion;
    private String telef;
    @Column(unique=true)
    private String nif;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, String poblacion, String telef, String nif) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telef = telef;
        this.nif = nif;
    }

    public Cliente(int id, String nombre, String direccion, String poblacion, String telef, String nif) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telef = telef;
        this.nif = nif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", telef='" + telef + '\'' +
                ", nif='" + nif + '\'' +
                '}';
    }
}

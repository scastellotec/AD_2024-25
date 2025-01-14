package Model;

import org.bson.types.ObjectId;

import java.util.List;

public class Autor {

    private ObjectId id;
    private String nombre;
    private List<String> categorias;
    private Boolean estaVivo;
    private int anno_nacimiento;

    // Constructo vacio
    public Autor(){}

    // Constructor con todos los campos
    public Autor(String nombre, List<String> categorias, Boolean estaVivo, int anno_nacimiento) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.estaVivo = estaVivo;
        this.anno_nacimiento = anno_nacimiento;
    }

    // Getter & Setters

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public Boolean getEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(Boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public int getAnno_nacimiento() {
        return anno_nacimiento;
    }

    public void setAnno_nacimiento(int anno_nacimiento) {
        this.anno_nacimiento = anno_nacimiento;
    }

    //TO-STRING
    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categorias=" + categorias +
                ", estaVivo=" + estaVivo +
                ", anno_nacimiento=" + anno_nacimiento +
                '}';
    }
}

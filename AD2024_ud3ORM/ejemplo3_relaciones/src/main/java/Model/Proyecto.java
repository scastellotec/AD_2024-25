package Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @ManyToMany
    private Set<Empleado> empleados = new HashSet<Empleado>();


    public Proyecto() {
    }

    public Proyecto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
        empleado.getProyectos().add(this);
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

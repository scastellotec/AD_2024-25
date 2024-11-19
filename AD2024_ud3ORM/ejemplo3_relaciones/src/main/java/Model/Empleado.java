package Model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @ManyToOne
    private Departamento dept;
    @ManyToMany(mappedBy = "empleados")
    private Set<Proyecto> proyectos = new HashSet<Proyecto>();

    public Empleado() {
    }

    public Empleado(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
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

    public Departamento getDept() {
        return dept;
    }

    public void setDept(Departamento dept) {
        this.dept = dept;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void addProyecto(Proyecto proyecto) {
        this.proyectos.add(proyecto);
        proyecto.getEmpleados().add(this);
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dept=" + dept +
                ", proyectos=" + proyectos +
                '}';
    }
}

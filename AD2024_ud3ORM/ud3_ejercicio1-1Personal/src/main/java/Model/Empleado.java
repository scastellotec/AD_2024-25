package Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emp")
    private long id;
    private String apellido;
    private String oficio;
    @Column(name = "fecha_alta")
    private Date fechAlta;
    private float salario;
    private float comision;
    //private int idDepartamento;


    public Empleado() {
    }

    public Empleado(String apellido, String oficio, Date fechAlta, float salario, float comision) {
        this.apellido = apellido;
        this.oficio = oficio;
        this.fechAlta = fechAlta;
        this.salario = salario;
        this.comision = comision;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Date getFechAlta() {
        return fechAlta;
    }

    public void setFechAlta(Date fechAlta) {
        this.fechAlta = fechAlta;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", oficio='" + oficio + '\'' +
                ", fechAlta=" + fechAlta +
                ", salario=" + salario +
                ", comision=" + comision +
                '}';
    }
}

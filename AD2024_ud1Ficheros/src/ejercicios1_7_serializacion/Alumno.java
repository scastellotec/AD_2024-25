package ejercicios1_7_serializacion;

import java.io.Serializable;

public class Alumno implements Serializable {

    private String nombre;
    private float nota;
    private int edad;

    public Alumno(String nombre, float nota, int edad) {
        this.nombre = nombre;
        this.nota = nota;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                ", edad=" + edad +
                '}';
    }
}

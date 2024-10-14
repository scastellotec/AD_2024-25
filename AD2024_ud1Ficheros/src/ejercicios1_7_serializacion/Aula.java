package ejercicios1_7_serializacion;

import java.io.Serializable;
import java.util.ArrayList;

public class Aula implements Serializable {

    private ArrayList<Alumno> alumnos;

    public Aula() {
        this.alumnos = new ArrayList<Alumno>();
    }

    public void addAlumno(Alumno a){
        this.alumnos.add(a);
    }

    @Override
    public String toString() {
        String resultado = "";
        for(Alumno a: alumnos){
            resultado += a.toString()+"\n";
        }
        return resultado;
    }
}

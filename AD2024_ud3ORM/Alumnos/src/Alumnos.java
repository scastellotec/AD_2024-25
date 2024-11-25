import java.util.List;

import java.util.List;

public class Alumnos {

    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("Juan", 7.5),
                new Alumno("Ana", 8.0),
                new Alumno("Pedro", 4.5)
        );

        // Paso 1: Filtrar alumnos con nota >= 5.
        alumnos.stream()
                .filter(alumno -> alumno.getNota() >= 5)
                .forEach(System.out::println); // Imprime: Juan (7.5), Ana (8.0)
    }
}

// Clase Alumno
class Alumno {
    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return nombre + " (" + nota + ")";
    }
}

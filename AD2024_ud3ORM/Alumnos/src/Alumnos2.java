import java.util.List;
import java.util.stream.Collectors;

public class Alumnos2 {

    public static void main(String[] args) {
        List<Alumno> alumnos = List.of(
                new Alumno("JUAN", 7.5),
                new Alumno("ANA", 8.0),
                new Alumno("PEDRO", 4.5)
        );

        // Paso 1: Transformar nombres de mayúsculas a minúsculas.
        List<String> nombresMinusculas = alumnos.stream()
                .map(alumno -> alumno.getNombre().toLowerCase()) // Transformar a minúsculas.
                .collect(Collectors.toList());

        // Paso 2: Mostrar los nombres en minúsculas.
        nombresMinusculas.forEach(System.out::println); // Imprime: juan, ana, pedro
    }
}

// Clase Alumno
class Alumno2 {
    private String nombre;
    private double nota;

    public Alumno2(String nombre, double nota) {
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

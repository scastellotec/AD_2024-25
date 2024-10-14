package ejercicios1_5_ficherosBinarios;

public class Persona {
    private String nombre;
    private int edad;
    private String ciudadNacimiento;

    public Persona(String nombre, int edad, String ciudadNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudadNacimiento='" + ciudadNacimiento + '\'' +
                '}';
    }
}

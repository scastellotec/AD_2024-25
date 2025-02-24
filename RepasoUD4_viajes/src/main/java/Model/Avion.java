package Model;

public class Avion {

    private String nombre;
    private int numero_pasajeros;

    public Avion() {
    }

    public Avion(String nombre, int numero_pasajeros) {
        this.nombre = nombre;
        this.numero_pasajeros = numero_pasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_pasajeros() {
        return numero_pasajeros;
    }

    public void setNumero_pasajeros(int numero_pasajeros) {
        this.numero_pasajeros = numero_pasajeros;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "nombre='" + nombre + '\'' +
                ", numero_pasajeros=" + numero_pasajeros +
                '}';
    }
}

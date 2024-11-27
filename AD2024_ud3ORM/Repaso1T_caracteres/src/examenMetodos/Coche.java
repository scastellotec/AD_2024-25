package examenMetodos;

public class Coche {

    private int id;
    private String marca;
    private String matricula;
    private boolean tieneSeguro;

    public Coche() {
    }

    public Coche(int id, String marca, String matricula, boolean tieneSeguro) {
        this.id = id;
        this.marca = marca;
        this.matricula = matricula;
        this.tieneSeguro = tieneSeguro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isTieneSeguro() {
        return tieneSeguro;
    }

    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", tieneSeguro=" + tieneSeguro +
                '}';
    }
}

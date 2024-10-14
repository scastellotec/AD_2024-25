package ejercicios1_8_xml;

public class Coche {

    private int id;
    private String marca;

    public Coche(int id, String marca) {
        this.id = id;
        this.marca = marca;
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

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                '}';
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public int CalculaMedia (int num1,int num2){
        int resultado = 0;

        /*..........*/

        return resultado;
    }
}

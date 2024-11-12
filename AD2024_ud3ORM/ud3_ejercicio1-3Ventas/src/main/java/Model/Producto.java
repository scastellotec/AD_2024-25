package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private int stockactual;
    private int stockminimo;
    private float precio;

    public Producto() {
    }

    public Producto(int id, String descripcion, int stockactual, int stockminimo, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.stockactual = stockactual;
        this.stockminimo = stockminimo;
        this.precio = precio;
    }

    public Producto(String descripcion, int stockactual, int stockminimo, float precio) {
        this.descripcion = descripcion;
        this.stockactual = stockactual;
        this.stockminimo = stockminimo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStockactual() {
        return stockactual;
    }

    public void setStockactual(int stockactual) {
        this.stockactual = stockactual;
    }

    public int getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(int stockminimo) {
        this.stockminimo = stockminimo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", stockactual=" + stockactual +
                ", stockminimo=" + stockminimo +
                ", precio=" + precio +
                '}';
    }
}

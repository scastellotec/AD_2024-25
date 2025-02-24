package Model;

import org.bson.types.ObjectId;

public class Vuelo {

    private ObjectId id;
    private String CiudadOrigen;
    private String CuidadDestino;
    private Avion avion;

    public Vuelo() {
    }

    public Vuelo(String ciudadOrigen, String cuidadDestino, Avion avion) {
        this.CiudadOrigen = ciudadOrigen;
        this.CuidadDestino = cuidadDestino;
        this.avion = avion;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCiudadOrigen() {
        return CiudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        CiudadOrigen = ciudadOrigen;
    }

    public String getCuidadDestino() {
        return CuidadDestino;
    }

    public void setCuidadDestino(String cuidadDestino) {
        CuidadDestino = cuidadDestino;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", CiudadOrigen='" + CiudadOrigen + '\'' +
                ", CuidadDestino='" + CuidadDestino + '\'' +
                ", avion=" + avion +
                '}';
    }
}

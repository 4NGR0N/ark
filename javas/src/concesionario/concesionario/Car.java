package concesionario;
import java.io.Serializable;

public class Car implements Serializable{
    private String marca;
    private String modelo;
    private int asientos;

    public Car(String marca, String modelo, int asientos) {
        this.marca = marca;
        this.modelo = modelo;
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", asientos=" + asientos +
                '}';
    }
}

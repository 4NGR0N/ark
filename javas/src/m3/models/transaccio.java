package m3.models;

import java.io.Serializable;
import java.time.LocalDate;

public class transaccio implements Serializable{
    private String tipus;
    private String importe;
    private LocalDate data;

    public transaccio(String tipus, String importe, LocalDate data) {
        this.tipus = tipus;
        this.importe = importe;
        this.data = data;
    }
    @Override
    public String toString() {
        return "Transacció{" +
                "tipus Moneda='" + tipus + '\'' +
                ", import='" + importe + '\'' +
                ", data=" + data +
                '}';
    }
}

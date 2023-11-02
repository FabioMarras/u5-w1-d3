package fabiomarras.u5w1d2.entities;

import lombok.ToString;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;

@ToString
@PropertySource("application.properties")
public class Order {
    private int numeroOrdine;
    private StatusOrder statusOrder;
    private int numeroCoperti;
    private LocalDateTime data;
    private Table tavolo;
    private List<Object> ordine;
    private double price;

    /*@Value("${priceCoperto}")
    private double priceCoperto;*/

    public Order(int numeroOrdine, StatusOrder statusOrder, int numeroCoperti, LocalDateTime data, Table tavolo, List<Object> ordine, double price) {
        this.numeroOrdine = numeroOrdine;
        this.statusOrder = statusOrder;
        this.numeroCoperti = numeroCoperti;
        this.data = data;
        this.tavolo = tavolo;
        this.ordine = ordine;
        this.price = price;
    }

}

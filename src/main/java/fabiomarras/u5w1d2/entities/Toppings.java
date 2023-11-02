package fabiomarras.u5w1d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Toppings {

    private String name;
    private int calories;
    private Double price;

    public Toppings(String name, int calories, Double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

}

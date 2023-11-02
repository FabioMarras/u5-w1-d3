package fabiomarras.u5w1d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Drinks {
    private String name;
    private String calories;
    private double price;

    public Drinks(String name, String calories, double price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

}

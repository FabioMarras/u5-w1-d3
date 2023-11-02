package fabiomarras.u5w1d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class Pizzas {
    private String name;
    private int calories;
    private Double price;
    private String BaseIngredients = "Cheese and Tomato";
    private List<Toppings> toppings;

    public Pizzas(String name, int calories, Double price, List<Toppings> toppings) {
        this.name = name;
        this.BaseIngredients = BaseIngredients;
        this.calories = calories;
        this.price = price;
        this.toppings = toppings;
    }
}

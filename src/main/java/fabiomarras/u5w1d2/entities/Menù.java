package fabiomarras.u5w1d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class Menù {
    private List<Pizzas> pizzas;
    private List<Drinks> drinks;
    private List<Toppings> toppings;

    public Menù(List<Pizzas> pizzas, List<Drinks> drinks, List<Toppings> toppings) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.toppings = toppings;
    }
}

package fabiomarras.u5w1d2;

import fabiomarras.u5w1d2.entities.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeansConfiguration {

    //PIZZE

    @Bean
    Pizzas PizzaIMargherita() {
        List<Toppings> margheritaToppings = Arrays.asList();
        return new Pizzas("Margherita",  1104,4.99 , margheritaToppings);
    }
    @Bean
    Pizzas PizzaIMargheritaXL(List<Toppings> allTopings) {
        List<Toppings> margheritaToppings = Arrays.asList(PizzaXL());
        return new Pizzas("MargheritaXL",  (1104 + PizzaXL().getCalories()),(4.99 + PizzaXL().getPrice()) , margheritaToppings);
    }

    @Bean
    Pizzas PizzaHawaiian() {
        List<Toppings> HawaiianToppings = Arrays.asList(Ham(), Pineaaple());
        return new Pizzas("Hawaiian", (1104 + Ham().getCalories() + Pineaaple().getCalories()), (4.99 + Ham().getPrice() + Pineaaple().getPrice()), HawaiianToppings);
    }

    @Bean
    Pizzas PizzaSalami(List<Toppings> allTopings) {
        List<Toppings> SalamiToppings = Arrays.asList(Salami());
        return new Pizzas("Salami",  (1104 + Salami().getCalories()), (4.99 + Salami().getPrice()), SalamiToppings);
    }
    @Bean
    public List<Pizzas> allPizzas(List<Toppings> allTopings) {
        return Arrays.asList(PizzaIMargherita(), PizzaIMargheritaXL(allTopings), PizzaSalami(allTopings), PizzaHawaiian());
    }

    //DRINKS
    @Bean
    public Drinks lemonade() {
        return new Drinks("Lemonade", "128", 1.29);
    }

    @Bean
    public Drinks water() {
        return new Drinks("Water", "0", 1.29);
    }

    @Bean
    public Drinks wine() {
        return new Drinks("Wine", "607", 7.49);
    }
    @Bean
    public List<Drinks> allDrinks() {
        return Arrays.asList(lemonade(), water(), wine());
    }

    //TOPPINGS
    @Bean
    public Toppings Cheese() {
        return new Toppings("Cheese", 92, 0.69);
    }
    @Bean
    public Toppings Tomato() {
        return new Toppings("Tomato", 50, 0.99);
    }
    @Bean
    public Toppings Ham() {
        return new Toppings("Ham", 35, 0.99);
    }
    @Bean
    public Toppings Onions() {
        return new Toppings("Onions", 22, 0.69);
    }
    @Bean
    public Toppings Pineaaple() {
        return new Toppings("Pineaaple", 24, 0.79);
    }
    @Bean
    public Toppings Salami() {
        return new Toppings("Salami", 86, 0.99);
    }
    @Bean
    public Toppings PizzaXL() {
        return new Toppings("PizzaXL", 130, 2.99);
    }
    @Bean
    public List<Toppings> allTopings() {
        return Arrays.asList(Cheese(), Tomato(), Ham(),Onions(), Pineaaple(), Salami());
    }

    //MENU
    @Bean
    public Menù allMenù (List<Pizzas> pizzas, List<Drinks> drinks, List<Toppings> toppings) {
        return new Menù(pizzas, drinks, toppings);
    }

    //TABLE
    @Bean
    Table tavolo1() {
        return new Table(1,6, StatusTavolo.LIBERO);
    }
    @Bean
    Table tavolo2() {
        return new Table(2,2, StatusTavolo.LIBERO);
    }
    @Bean
    Table tavolo3() {
        return new Table(3,10, StatusTavolo.LIBERO);
    }
    @Bean
    Table tavolo4() {
        return new Table(4,4, StatusTavolo.OCCUPATO);
    }

    @Bean
    Order ordine1(@Value("${priceCoperto}") double priceCoperto) {
        List<Object> order1elements = Arrays.asList(PizzaIMargherita(), PizzaHawaiian(), lemonade());
        int numeroCoperti = 2;
        Table tavoloOrdine = tavolo2();
        if (numeroCoperti > tavoloOrdine.getNumeroCopertiMax()) {
            System.err.println("Tavolo troppo piccolo");
            return null;
        } else {
            return new Order(1, StatusOrder.IN_CORSO, numeroCoperti, LocalDateTime.now(), tavoloOrdine, order1elements, (PizzaIMargherita().getPrice() + PizzaHawaiian().getPrice() + lemonade().getPrice() + priceCoperto*numeroCoperti));
        }
    }
}

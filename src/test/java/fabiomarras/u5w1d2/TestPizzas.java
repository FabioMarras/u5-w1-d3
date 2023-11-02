package fabiomarras.u5w1d2;

import fabiomarras.u5w1d2.entities.Drinks;
import fabiomarras.u5w1d2.entities.Pizzas;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPizzas {

    @Autowired
    private Pizzas PizzaIMargherita;

    @Autowired
    private Pizzas PizzaIMargheritaXL;

    @Autowired
    private Drinks water;

    @Autowired
    private Drinks lemonade;

    @Autowired
    private List<Drinks> allDrinks;

    @BeforeAll
    static void beforeAll(){
        System.out.println("BEFORE ALL");
    }

    @Test
    public void testPrice() {
        System.out.println("TestPrice");

        //assertNotNull(pizza);
        assertTrue(PizzaIMargherita.getPrice() > 0.00);
    }

    @Test
    public void drink0Calories(){
        System.out.println("drink0Calories");
        assertEquals(water.getCalories(), 0.00);
    }

    @Test
    public void lemondeIsPresence(){
        System.out.println("lemondeIsPresence");
        assertEquals("lemonade", lemonade.getName());
    }

    @Test
    public void notSamePizza(){
        System.out.println("notSamePizza");
        assertNotEquals("PizzaIMargherita", "PizzaIMargheritaXL");
    }

    @ParameterizedTest
    @ValueSource(strings = {"L", "l", "p"})
    void findByLetterL(String letterL) {
        List<Drinks> allDrink = allDrinks.stream().filter(drinks -> drinks.getName().startsWith(letterL)).toList();
                assertEquals(allDrink.size(),1);
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("After ALL, FINISH");
    }
}
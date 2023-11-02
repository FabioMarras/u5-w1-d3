package fabiomarras.u5w1d2;

import fabiomarras.u5w1d2.entities.Pizzas;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPizzas {

    @Autowired
    private Pizzas pizza;

    @BeforeAll
    static void beforeAll(){
        System.out.println("BEFORE ALL");
    }

    @Test
    public void testPrice() {
        System.out.println("TestPrice");

        //assertNotNull(pizza);
        assertTrue(pizza.getPrice() > 0.00);
    }
}
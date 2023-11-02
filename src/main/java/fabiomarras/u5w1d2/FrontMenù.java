package fabiomarras.u5w1d2;

import fabiomarras.u5w1d2.entities.Menù;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FrontMenù implements CommandLineRunner {
    private Menù menù;
    @Autowired
    public FrontMenù(Menù menù){
        this.menù = menù;
    }
    @Override
    public void run(String... args) throws Exception {
        log.info("Questo è il menù: " + menù);
    }
}

package fabiomarras.u5w1d2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Table {
    private int numeroTavolo;
    private int numeroCopertiMax;
    private StatusTavolo statusTavolo;
}

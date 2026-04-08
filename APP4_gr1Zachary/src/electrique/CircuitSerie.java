package electrique;

import java.util.List;

public class CircuitSerie extends Circuit {


    public CircuitSerie(List<Composant> composants) {
        super(composants);
    }


    @Override
    public double calculerResistance() {
        double resistanceTotal = 0;
        for (Composant c : getComposants()) {
            resistanceTotal += c.calculerResistance();
        }
        return resistanceTotal;
    }
}

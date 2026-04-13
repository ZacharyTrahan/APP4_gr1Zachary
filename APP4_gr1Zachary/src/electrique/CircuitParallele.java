package electrique;

import java.util.List;

public class CircuitParallele extends Circuit {

    public CircuitParallele(List<Composant> composants) {
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double resistanceTotal = 0;
        for (Composant c : getComposants()) {
            double resCheque = c.calculerResistance();
            if (resCheque == 0) {
                return 0;
            }
            resistanceTotal += 1.0 / resCheque;
        }
        if (resistanceTotal == 0) {
            return 0;
        }
        return 1.0 / resistanceTotal;
    }
}


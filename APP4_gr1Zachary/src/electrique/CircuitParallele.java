package electrique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CircuitParallele extends Circuit {

    public CircuitParallele(List<Composant> composants) {
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double resistanceTotal = 0;
        for (Composant c : getComposants()) {
            double resCheque = c.calculerResistance();
            if (resCheque > 0) {
                resistanceTotal += 1 / resCheque;
            }
        }
        return 1 / resistanceTotal;
    }
}


package electrique;

import java.util.List;

public class CircuitParallele extends Circuit {

    public static void main(String[] args) {

    }

    public CircuitParallele(List<Composant> composants) {
        super(composants);
        System.out.println(calculerResistance());
    }

    @Override
    public double calculerResistance() {
        double resistanceTotal=0;
        for (Composant c :getComposants() ){
            resistanceTotal+=1/c.calculerResistance();
        }
        return 1.0/resistanceTotal;
    }
    }


package electrique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CircuitParallele extends Circuit {

    public static void main(String[] args) {
        ArrayList<Composant> comp = new ArrayList<>();
        comp.add(new Resistance(10000));
        comp.add(new Resistance(2000));
        comp.add(new Resistance(1000));

        CircuitParallele cp = new CircuitParallele(comp);
        double resultat = cp.calculerResistance();
        System.out.println(resultat);
    }

    public CircuitParallele(List<Composant> composants) {
        super(composants);

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


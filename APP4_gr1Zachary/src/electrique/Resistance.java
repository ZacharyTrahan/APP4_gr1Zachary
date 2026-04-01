package electrique;

public class Resistance extends Composant{
protected double resistance;
    public Resistance(double resistance){

    }

    @Override
    public double calculerResistance() {
        return 3;
    }
}

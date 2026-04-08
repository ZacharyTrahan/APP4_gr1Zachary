package electrique;

public class Resistance extends Composant{
protected double resistance;
    public Resistance(double resistance){
this.resistance=resistance;
    }

    @Override
    public double calculerResistance() {
        return this.resistance;
    }
}

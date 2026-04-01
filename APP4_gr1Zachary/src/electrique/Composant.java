package electrique;

public abstract class Composant {

    public Composant(){
        calculerResistance();
    }

    public double calculerResistance(){
        return 4;
    }
}

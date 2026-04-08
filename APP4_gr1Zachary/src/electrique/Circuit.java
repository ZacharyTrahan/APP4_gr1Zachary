package electrique;

import java.util.List;

public abstract class Circuit extends Composant {


    private List<Composant> composants;

    public Circuit(List<Composant> composants) {
        super();
        setComposants(composants);
    }


    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

}
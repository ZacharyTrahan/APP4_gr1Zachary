package electrique;

import java.util.List;

public  class Circuit extends Composant {


    private List<Composant> composants;

    public Circuit(List<Composant> composants) {
        this.composants = composants;
    }


    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }
}
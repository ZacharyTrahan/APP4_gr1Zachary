package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import electrique.*;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import static app.CircuitApp.pathIn;


public class CircuitBuilder {


    public CircuitBuilder() {

    }


    public Composant construireCircuit() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode Node = mapper.readTree(new File(pathIn));
            JsonNode circuitNode;
            if (Node.has("circuit")) {
                circuitNode = Node.get("circuit");
            } else {
                circuitNode = Node;
            }

            return lireComposant(circuitNode);

        } catch (IOException e) {
            System.err.println("Erreur de lecture : " + e.getMessage());
            return null;
        }
    }

    private Composant lireComposant(JsonNode node) {
        String type = node.get("type").asText();

        if ("resistance".equals(type)) {
            return new Resistance(node.get("valeur").asDouble());
        } else if ("parallele".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireComposant(composantNode));
            }
            return new CircuitParallele(composants);
        }

        else if ("serie".equals(type)) {
            List<Composant> composants = new ArrayList<>();
            for (JsonNode composantNode : node.get("composants")) {
                composants.add(lireComposant(composantNode));
            }
            return new CircuitSerie(composants);
        }
        throw new IllegalArgumentException("type de circuit inconnu");
    }

}




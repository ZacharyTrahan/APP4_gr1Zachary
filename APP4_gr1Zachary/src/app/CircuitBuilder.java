package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import electrique.*;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


public class CircuitBuilder {

    private static final char fSep = File.separatorChar;
    // Chemins des fichiers pour lire et écrire les données des composant
    private static String pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "donnee" + fSep + "fichier_json" + fSep + "complexe_industriel_zone_nord.json";

    public CircuitBuilder() {
        CircuitApp choixFichier= new CircuitApp();
        selecteurFichier(choixFichier.toString());
    }

    public String selecteurFichier(String choixFichier) {
        if (choixFichier.equals("nord.json")) {
            return pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "donnee" + fSep + "fichier_json" + fSep + "complexe_industriel_zone_nord.json";
        } else if (choixFichier.equals("quartier.json")) {
            return pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "donnee" + fSep + "fichier_json" + fSep + "eclairage_public_qiartoer.json";

        } else if (choixFichier.equals("hopital.json")) {
            return pathIn = System.getProperty("user.dir") + fSep + "scr" + fSep + "donnee" + fSep + "fichier_json" + fSep + "reseau_secours_hopital.json";

        }
        return null;
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
        String valeur = node.get("valeur").asText();

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




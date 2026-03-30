/*package app;

import electrique.Composant;

import java.io.File;
import java.util.ArrayList;

public class CircuitBuilder {

    private static final char fSep = File.separatorChar;


    // Chemins des fichiers pour lire et écrire les données des composant
    private static String pathIn = System.getProperty("user.dir") + fSep + "src" + fSep + "donnee" + fSep + "fichier_json" + fSep + "complexe_industriel_zone_nord.json";

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

    public Composant construireCircuit(String pathIn) {
        JSONObject obj = new JSONObject(pathIn);
    }

    private Composant lireComposant(JsonNode) {
        return composant;
    }
}
*/


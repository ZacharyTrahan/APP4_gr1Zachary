package app;

import java.io.File;
import java.util.Scanner;


public class CircuitApp {
    private Scanner sc = new Scanner(System.in);
    private static final char fSep = File.separatorChar;
    protected static String pathIn;

    public CircuitApp() {

        boolean boucleRequstionnement = true;
        while (boucleRequstionnement) {
            demandeInfoFichierDispo();
            utilisationFichier();
            boucleRequstionnement = requestionnement();
        }

    }

    public static void main(String[] args) {
        new CircuitApp();
    }

    public String demandeInfoFichierDispo() {
        boolean valide = false;
        String choixFichier = "";
        System.out.println("\nType de fichier disponible:\n" +
                "[1] circuit nord.json\n" +
                "[2] circuit quartier.json\n" +
                "[3] circuit hopital.json");
        System.out.print("Quel fichier voulez-vous accéder ? : ");

        while (!valide) {
            if (sc.hasNextInt()) {
                int reponseFichier = sc.nextInt();
                sc.nextLine();
                if (reponseFichier >= 1 && reponseFichier <= 3) {
                    if (reponseFichier == 1) {
                        pathIn = System.getProperty("user.dir") + fSep + "APP4_gr1Zachary" + fSep + "src" + fSep + "donnee" + fSep + "fichiers_json" + fSep + "complexe_industriel_zone_nord.json";

                    } else if (reponseFichier == 2) {
                        pathIn = System.getProperty("user.dir") + fSep + "APP4_gr1Zachary" + fSep + "src" + fSep + "donnee" + fSep + "fichiers_json" + fSep + "eclairage_public_quartier.json";
                    } else if (reponseFichier == 3) {
                        pathIn = System.getProperty("user.dir") + fSep + "APP4_gr1Zachary" + fSep + "src" + fSep + "donnee" + fSep + "fichiers_json" + fSep + "reseau_secours_hopital.json";
                    }

                    System.out.println("OUVERTURE DU FICHIER " + choixFichier + " !");
                    valide = true;
                } else {
                    System.out.println("Erreur: Entrez un chiffre entre 1 et 3.");

                }
            } else {
                System.out.println("Erreur: Veuillez entrer un nombre valide.");
                sc.nextLine();
            }
        }
        return pathIn;
    }


    public void utilisationFichier() {
        System.out.println("construction de circuit.");
        CircuitBuilder cb = new CircuitBuilder();
        cb.construireCircuit();
    }

    public boolean requestionnement() {
        System.out.println("\n[R] Recommencer\n[Q] Quitter");
        String reponse = sc.nextLine().toUpperCase();

        if (reponse.equals("R")) {
            return true;
        } else {
            System.out.printf("fermeture du fichier en cours.");
            System.out.println("Bonne journée !");
        }
    }
}




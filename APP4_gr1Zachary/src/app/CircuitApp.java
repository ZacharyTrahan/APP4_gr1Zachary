package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CircuitApp {

    public CircuitApp() {
        demandeInfoFichierDispo();
        utilisationFichier();
        requestionnement();
    }

    public static void main(String[] args) {
        new CircuitApp();
    }

    private String demandeInfoFichierDispo() {
        boolean valide = false;
        String reponseFinal = "gggg";
        String choixFichier = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("type de fichier disponible:\n" +
                "[1]circuit nord.json\n" +
                "[2]circuit quartier.json\n" +
                "[3]circuit hopital.json\n");
        System.out.println("Quelles fichiers voulez vous accèder?");
        while (!valide) {
            if (sc.hasNextInt()) {
                int reponseFichier = sc.nextInt();
                if (reponseFichier <= 3 && reponseFichier >= 1) {

                    if (reponseFichier == 1) {
                        choixFichier = "nord.json";
                    } else if (reponseFichier == 2) {
                        choixFichier = "quartier.json";
                    } else if (reponseFichier == 3) {
                        choixFichier = "hopital.json";
                    }
                    System.out.println("OUVERTURE DU FICHIER " + choixFichier + "!");

                    valide = true;
                } else {
                    valide = false;
                    System.out.println("Erreur: réponse non comprise dans les choix proposés\n " +
                            "vieuller entrer un chiffre valide");
                    sc.next();
                }
            } else {

                System.out.println("Erreur: reponse non comprise dans les choix proposer\n " +
                        "veuiller entrer un chiffre valide.");
                sc.next();
            }
        }
        return choixFichier;
    }

    public void utilisationFichier() {
        CircuitBuilder cb = new CircuitBuilder();
        cb.construireCircuit();
    }

    public void requestionnement() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[R] Tester un autre fihcier :" +
                "[Q] Quitter");
        String reponse = sc.nextLine();
        String reponseConverti = reponse.toUpperCase();
        if (reponseConverti.equals("R")) {
            demandeInfoFichierDispo();
        } else if (reponseConverti.equals("Q")) {
            System.out.println("bonne journée");
            System.exit(0);
        }
    }

}

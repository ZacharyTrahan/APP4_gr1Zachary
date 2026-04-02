package app;

import java.util.Scanner;

public class CircuitApp {
    private Scanner sc = new Scanner(System.in);

    public CircuitApp() {
        boolean boucleRequstionnement = true;
        while (boucleRequstionnement) {
            String fichier = demandeInfoFichierDispo();
            utilisationFichier();
            boucleRequstionnement = requestionnement();
        }
    }

    public static void main(String[] args) {
        new CircuitApp();
    }

    private String demandeInfoFichierDispo() {
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
                        choixFichier = "nord.json";
                    } else if (reponseFichier == 2) {
                        choixFichier = "quartier.json";
                    } else if (reponseFichier == 3) {
                        choixFichier = "hopital.json";
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
        return choixFichier;
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
            System.out.println("Bonne journée !");
            return false;
        }
    }
}



package tirage;

import java.io.*;

/**
 *
 * @author Romuald
 */
public class Fichier {

    public Fichier() {
        System.out.println("Ouverture du fichier...");
        String ligne = "";
        String fichier = "precedent.txt";
        
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader ficTexte;
        try {
                ficTexte = new BufferedReader(new FileReader(new File(fichier)));
                if (ficTexte == null) {
                        throw new FileNotFoundException("Fichier non trouvé: "+ fichier);
                }
                do {
                        ligne = ficTexte.readLine();
                        if (ligne != null) {
                                System.out.println(ligne);
                        }
                } while (ficTexte != null);
                ficTexte.close();
                System.out.println("\n");
        } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
        } catch (IOException e) {
                System.out.println(e.getMessage());
        }
    }
}

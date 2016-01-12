package tirage;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
/**
 *
 * @author Romuald
 */
public class Fichier {

    private static Pattern pattern1;
    private static Matcher matcher1;
    private String ligne = "";
    private static Structure[] tab_file;
    
    public Fichier() {
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
                            regex();
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
    
    public void regex() {
        pattern1 = Pattern.compile("(([1-9]|[1][0-2])\\:(\\w{1,9})\\;)");
        matcher1 = pattern1.matcher(ligne);
        
        int i = 0;
        tab_file = new Structure[4];
        while(matcher1.find()) {
            tab_file[i] = new Structure(matcher1.group(2), matcher1.group(3));
            //System.out.println(matcher1.group(2)+matcher1.group(3));
            i++;
        }
    }
    
    public void test() {
        System.out.println("ah que coucou");
    }
}

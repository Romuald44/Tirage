package tirage;
import java.io.*;
import java.util.regex.*;
/**
 *
 * @author Romuald
 */
public class Tirage {

    private static Fenetre frame;
    private static Fichier iofile;
    static int animateur;
    static int secretaire;
    static int scribe;
    static int gestionnaire;
    private static Pattern pattern1;
    private static Matcher matcher1;
    private String ligne = "";
    private static Structure[] tab_file;
    private static String[] receive;
            
    public static void main(String[] args) {
        frame = new Fenetre();
        iofile = new Fichier();
    }
    
    public static String selection() {
        animateur = random();
        secretaire = random();
        scribe = random();
        gestionnaire = random();
        
        receive = iofile.view_tab().split(",");
        
        while(animateur == Integer.parseInt(receive[0])) {
            animateur = random();
        }
        
        //System.out.println("Animateur => "+nom(animateur));
        
        while(secretaire == animateur || secretaire == Integer.parseInt(receive[1])) {
            secretaire = random();
        }
        //System.out.println("Secrétaire => "+nom(secretaire));
        
        while(scribe == animateur || scribe == secretaire || scribe == Integer.parseInt(receive[2])) {
            scribe = random();
        }
        //System.out.println("Scribe => "+nom(scribe));
        
        while(gestionnaire == animateur || gestionnaire == secretaire || gestionnaire == scribe || gestionnaire == Integer.parseInt(receive[3])) {
            gestionnaire = random();
        }
        //System.out.println("Gestionnaire => "+nom(gestionnaire));
        return affichage(animateur, secretaire, scribe, gestionnaire);
    }
    
    public static String animateur() {
        int new_animateur = random();
        while(new_animateur == animateur || new_animateur == gestionnaire ||
                new_animateur == secretaire || new_animateur == scribe ||
                new_animateur == Integer.parseInt(receive[0]) || new_animateur == Integer.parseInt(receive[1]) ||
                new_animateur == Integer.parseInt(receive[2]) || new_animateur == Integer.parseInt(receive[3])) {
            new_animateur = random();
        }
        animateur = new_animateur;
        return "Animateur => "+nom(animateur)+"\n"+"Secrétaire => "+nom(secretaire)+"\n"+"Scribe => "+nom(scribe)+"\n"+"Gestionnaire => "+nom(gestionnaire);
    }
    
    public static String secretaire() {
        int new_secretaire = random();
        while(new_secretaire == secretaire || new_secretaire == gestionnaire ||
                new_secretaire == animateur || new_secretaire == scribe ||
                new_secretaire == Integer.parseInt(receive[0]) || new_secretaire == Integer.parseInt(receive[1]) ||
                new_secretaire == Integer.parseInt(receive[2]) || new_secretaire == Integer.parseInt(receive[3])) {
            new_secretaire = random();
        }
        secretaire = new_secretaire;
        return "Animateur => "+nom(animateur)+"\n"+"Secrétaire => "+nom(secretaire)+"\n"+"Scribe => "+nom(scribe)+"\n"+"Gestionnaire => "+nom(gestionnaire);
    }
    
    public static String scribe() {
        int new_scribe = random();
        while(new_scribe == scribe || new_scribe == gestionnaire ||
                new_scribe == secretaire || new_scribe == animateur ||
                new_scribe == Integer.parseInt(receive[0]) || new_scribe == Integer.parseInt(receive[1]) ||
                new_scribe == Integer.parseInt(receive[2]) || new_scribe == Integer.parseInt(receive[3])) {
            new_scribe = random();
        }
        scribe = new_scribe;
        return "Animateur => "+nom(animateur)+"\n"+"Secrétaire => "+nom(secretaire)+"\n"+"Scribe => "+nom(scribe)+"\n"+"Gestionnaire => "+nom(gestionnaire);
    }
    
    public static String gestionnaire() {
        int new_gestionnaire = random();
        while(new_gestionnaire == gestionnaire || new_gestionnaire == animateur ||
                new_gestionnaire == secretaire || new_gestionnaire == scribe ||
                new_gestionnaire == Integer.parseInt(receive[0]) || new_gestionnaire == Integer.parseInt(receive[1]) ||
                new_gestionnaire == Integer.parseInt(receive[2]) || new_gestionnaire == Integer.parseInt(receive[3])) {
            new_gestionnaire = random();
        }
        gestionnaire = new_gestionnaire;
        return "Animateur => "+nom(animateur)+"\n"+"Secrétaire => "+nom(secretaire)+"\n"+"Scribe => "+nom(scribe)+"\n"+"Gestionnaire => "+nom(gestionnaire);
    }
    
    public static int random() {
        int nbAleatoire = (int)(Math.random() * 12 + 1);
        return nbAleatoire;
    }
    
    public static String nom(int adr) {
        String tableauNom[] = {"Fabien", "Romain", "Floran" , "Guillaume", "Romuald", "Clément", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
        return tableauNom[adr-1];
    }
    
    public static String affichage(int anim, int secret, int scrib, int gestio) {
        return "Animateur => "+nom(anim)+"\n"+"Secrétaire => "+nom(secret)+"\n"+"Scribe => "+nom(scrib)+"\n"+"Gestionnaire => "+nom(gestio);
    }
}

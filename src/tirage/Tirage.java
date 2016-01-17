package tirage;
import java.util.regex.*;
import java.util.*;
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
    private static String name_tirage[] = {"Fabien", "Romain", "Florent" , "Guillaume", "Romuald", "Clement", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
    
    public static void main(String[] args) {
        XML test = new XML();
        test.save_tab();
        test.view_nb_save_tab();
        //frame = new Fenetre();
        //iofile = new Fichier();
    }
    
    public static String selection() {
        animateur = moins_anim();
        secretaire = moins_secret();
        scribe = moins_scribe();
        gestionnaire = moins_gest();
        
        if(receive == null) {receive = iofile.view_tab().split(",");}
        
        while(animateur == Integer.parseInt(receive[0]) || animateur == Integer.parseInt(receive[1]) ||
                animateur == Integer.parseInt(receive[2]) || animateur == Integer.parseInt(receive[3])) {
            animateur = random();
        }
        
        //System.out.println("Animateur => "+nom(animateur));
        
        while(secretaire == animateur || secretaire == Integer.parseInt(receive[0]) || secretaire == Integer.parseInt(receive[1]) ||
                secretaire == Integer.parseInt(receive[2]) || secretaire == Integer.parseInt(receive[3])) {
            secretaire = random();
        }
        //System.out.println("Secrétaire => "+nom(secretaire));
        
        while(scribe == animateur || scribe == secretaire || scribe == Integer.parseInt(receive[0]) || scribe == Integer.parseInt(receive[1]) ||
                scribe == Integer.parseInt(receive[2]) || scribe == Integer.parseInt(receive[3])) {
            scribe = random();
        }
        //System.out.println("Scribe => "+nom(scribe));
        
        while(gestionnaire == animateur || gestionnaire == secretaire || gestionnaire == scribe ||
                gestionnaire == Integer.parseInt(receive[0]) || gestionnaire == Integer.parseInt(receive[1]) ||
                gestionnaire == Integer.parseInt(receive[2]) || gestionnaire == Integer.parseInt(receive[3])) {
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
        String tableauNom[] = {"Fabien", "Romain", "Florent" , "Guillaume", "Romuald", "Clément", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
        return tableauNom[adr-1];
    }
    
    public static String affichage(int anim, int secret, int scrib, int gestio) {
        return "Animateur => "+nom(anim)+"\n"+"Secrétaire => "+nom(secret)+"\n"+"Scribe => "+nom(scrib)+"\n"+"Gestionnaire => "+nom(gestio);
    }
    
    public static int moins_anim() {
        final String[][] data = new String[12][2];

        for(int i = 0; i < 12; i++) {
            data[i][0] = Integer.toString(iofile.freq_anim(i));
            data[i][1] = name_tirage[i];
        }
        
        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = data[0][1];
        System.out.println("Moins Animateur = "+rep);
        int rep_int = iofile.correspondance(rep);
        return rep_int;
    }
    
    public static int moins_secret() {
        final String[][] data = new String[12][2];

        for(int i = 0; i < 12; i++) {
            data[i][0] = Integer.toString(iofile.freq_secret(i));
            data[i][1] = name_tirage[i];
        }
        
        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = data[0][1];
        System.out.println("Moins Secrétaire = "+rep);
        int rep_int = iofile.correspondance(rep);
        return rep_int;
    }
    
    public static int moins_scribe() {
        final String[][] data = new String[12][2];

        for(int i = 0; i < 12; i++) {
            data[i][0] = Integer.toString(iofile.freq_scribe(i));
            data[i][1] = name_tirage[i];
        }
        
        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = data[0][1];
        System.out.println("Moins Scribe = "+rep);
        int rep_int = iofile.correspondance(rep);
        return rep_int;
    }
    
    public static int moins_gest() {
        final String[][] data = new String[12][2];

        for(int i = 0; i < 12; i++) {
            data[i][0] = Integer.toString(iofile.freq_gest(i));
            data[i][1] = name_tirage[i];
        }
        
        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = data[0][1];
        System.out.println("Moins Gestionnaire = "+rep);
        int rep_int = iofile.correspondance(rep);
        return rep_int;
    }
}

package tirage;
/**
 *
 * @author Romuald
 */
public class Tirage {

    private static Fenetre frame;
    private static XML xml;
    static int animateur;
    static int secretaire;
    static int scribe;
    static int gestionnaire;
    private static String[] receive = null;
    static String[][] test_anim = null;
    static String[][] test_secret = null;
    static String[][] test_scribe = null;
    static String[][] test_gest = null;
    
    public static void main(String[] args) {
        frame = new Fenetre();
        xml = new XML();
        xml.save_tab();
    }
    
    public static int tab_moin_anim() {
        test_anim = xml.moins_anim();
        
        for(int i=0; i<12; i++) {
            System.out.println("Animateur = "+test_anim[i][1]+" Nombre = "+test_anim[i][0]);
        }
        
        String result = test_anim[0][1];
        
        int incre=0;
        while(test_anim[incre][1].equals(receive[0]) || test_anim[incre][1].equals(receive[1]) ||
                test_anim[incre][1].equals(receive[2]) || test_anim[incre][1].equals(receive[3])) {
            result = test_anim[incre][1];
            incre++;
        }
        
        return Integer.parseInt(result);
    }
    
    public static int tab_moin_secret() {
        test_secret = xml.moins_secret();
        
        for(int i=0; i<12; i++) {
            System.out.println("Secrétaire = "+test_secret[i][1]+" Nombre = "+test_secret[i][0]);
        }
        
        String secret = test_secret[0][1];
        
        int incre=0;
        while(test_secret[incre][1].equals(receive[0]) || test_secret[incre][1].equals(receive[1]) ||
                test_secret[incre][1].equals(receive[2]) || test_secret[incre][1].equals(receive[3])) {
            secret = test_secret[incre][1];
            incre++;
        }
            
        /*if(test_secret[0][1] == test_anim[0][1]) {
            secret = test_secret[1][1];
        }
        else if(test_secret[1][1] == test_anim[1][1]) {
            secret = test_secret[2][1];
        }
        else if(test_secret[2][1] == test_anim[2][1]) {
            secret = test_secret[3][1];
        }*/
        
        return Integer.parseInt(secret);
    }
    
    public static int tab_moin_scribe() {
        test_scribe = xml.moins_scribe();
        
        for(int i=0; i<12; i++) {
            System.out.println("Scribe = "+test_scribe[i][1]+" Nombre = "+test_scribe[i][0]);
        }
        
        String scribe = test_scribe[0][1];
        
        int incre=0;
        while(test_scribe[incre][1].equals(receive[0]) || test_scribe[incre][1].equals(receive[1]) ||
                test_scribe[incre][1].equals(receive[2]) || test_scribe[incre][1].equals(receive[3])) {
            scribe = test_scribe[incre][1];
            incre++;
        }
        /*if(test_scribe[0][1].equals(test_anim[0][1]) || test_scribe[0][1].equals(test_secret[0][1])) {
            scribe = test_scribe[1][1];
        }
        else if(test_scribe[1][1].equals(test_anim[1][1]) || test_scribe[1][1].equals(test_secret[1][1])) {
            scribe = test_scribe[2][1];
        }
        else if(test_scribe[2][1].equals(test_anim[2][1]) || test_scribe[2][1].equals(test_secret[2][1])) {
            scribe = test_scribe[3][1];
        }*/
        
        return Integer.parseInt(scribe);
    }
    
    public static int tab_moin_gest() {
        test_gest = xml.moins_gest();
        
        for(int i=0; i<12; i++) {
            System.out.println("Gestionnaire = "+test_gest[i][1]+" Nombre = "+test_gest[i][0]);
        }
        
        String gest = test_gest[0][1];
        
        int incre=0;
        while(test_gest[incre][1].equals(receive[0]) || test_gest[incre][1].equals(receive[1]) ||
                test_gest[incre][1].equals(receive[2]) || test_gest[incre][1].equals(receive[3])) {
            gest = test_gest[incre][1];
            incre++;
        }
        /*if(test_gest[0][1].equals(test_anim[0][1]) || test_gest[0][1].equals(test_secret[0][1]) || test_gest[0][1].equals(test_scribe[0][1])) {
            gest = test_gest[1][1];
        }
        else if(test_gest[1][1].equals(test_anim[1][1]) || test_gest[1][1].equals(test_secret[1][1]) || test_gest[1][1].equals(test_scribe[1][1])) {
            gest = test_gest[2][1];
        }
        else if(test_gest[2][1].equals(test_anim[2][1]) || test_gest[2][1].equals(test_secret[2][1]) || test_gest[2][1].equals(test_scribe[2][1])) {
            gest = test_gest[3][1];
        }*/
        
        return Integer.parseInt(gest);
    }
    
    public static String selection() {
        xml.read();
        xml.save_tab();
        
        receive = xml.last_nb_save_tab().split(",");
        
        animateur = tab_moin_anim();
        System.out.println(animateur);
        
        secretaire = tab_moin_secret();
        System.out.println(secretaire);
        
        scribe = tab_moin_scribe();
        System.out.println(scribe);
        
        gestionnaire = tab_moin_gest();
        System.out.println(gestionnaire);
        
        System.out.println(receive[0]+" "+receive[1]+" "+receive[2]+" "+receive[3]);
        
        /*while(animateur == Integer.parseInt(receive[0]) || animateur == Integer.parseInt(receive[1]) ||
                animateur == Integer.parseInt(receive[2]) || animateur == Integer.parseInt(receive[3])) {
            animateur = random();
        }*/
        
        //System.out.println("Animateur => "+nom(animateur));
        
        /*while(secretaire == animateur || secretaire == Integer.parseInt(receive[0]) || secretaire == Integer.parseInt(receive[1]) ||
                secretaire == Integer.parseInt(receive[2]) || secretaire == Integer.parseInt(receive[3])) {
            secretaire = random();
        }*/
        //System.out.println("Secrétaire => "+nom(secretaire));
        
        /*while(scribe == animateur || scribe == secretaire || scribe == Integer.parseInt(receive[0]) || scribe == Integer.parseInt(receive[1]) ||
                scribe == Integer.parseInt(receive[2]) || scribe == Integer.parseInt(receive[3])) {
            scribe = random();
        }*/
        //System.out.println("Scribe => "+nom(scribe));
        
        /*while(gestionnaire == animateur || gestionnaire == secretaire || gestionnaire == scribe ||
                gestionnaire == Integer.parseInt(receive[0]) || gestionnaire == Integer.parseInt(receive[1]) ||
                gestionnaire == Integer.parseInt(receive[2]) || gestionnaire == Integer.parseInt(receive[3])) {
            gestionnaire = random();
        }*/
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
        String tableauNom[] = {"Fabien", "Romain", "Florent" , "Guillaume", "Romuald", "Clement", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
        return tableauNom[adr];
    }
    
    public static String affichage(int anim, int secret, int scrib, int gestio) {
        return "Animateur => "+nom(anim)+"\n"+"Secrétaire => "+nom(secret)+"\n"+"Scribe => "+nom(scrib)+"\n"+"Gestionnaire => "+nom(gestio);
    }
    
    public static int getanimateur() {
        return animateur;
    }
    
    public static int getsecretaire() {
        return secretaire;
    }
    
    public static int getscribe() {
       return scribe;
    }
    
    public static int getgestionnaire() {
        return gestionnaire;
    }
}

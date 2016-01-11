/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tirage;

/**
 *
 * @author Romuald
 */
public class Tirage {

    private static Fenetre frame;
       
    public static void main(String[] args) {
        //frame = new Fenetre();
        selection();
    }
    
    public static String selection() {
        int tab_pers[] = null;
        int pre_random=0;
        int act_random=0;
        /*int animateur = random();
        int secretaire = random();
        int scribe = random();
        int gestionnaire = random();*/
        
        //System.out.println("Animateur => "+nom(animateur));
        
        for(int i=0; i<4; i++) {
            pre_random = random();
            
            if(i>=1) {
                act_random = random();
            }
            
            if(act_random != pre_random) {
                tab_pers[i] = act_random;
                System.out.println(tab_pers[i]);
            }
        }
        
        return "";
        /*while(secretaire == animateur) {
            secretaire = random();
        }*/
        //System.out.println("Secrétaire => "+nom(secretaire));
        
       /* while(scribe == animateur || scribe == secretaire) {
            scribe = random();
        }*/
        //System.out.println("Scribe => "+nom(scribe));
        
        /*while(gestionnaire == animateur || gestionnaire == secretaire || gestionnaire == scribe) {
            gestionnaire = random();
        }*/
        //System.out.println("Gestionnaire => "+nom(gestionnaire));
        //return "Animateur => "+nom(animateur)+"\n"+"Secrétaire => "+nom(secretaire)+"\n"+"Scribe => "+nom(scribe)+"\n"+"Gestionnaire => "+nom(gestionnaire);
    }
    
    public static int random() {
        int nbAleatoire = (int)(Math.random() * 12 + 1);
        return nbAleatoire;
    }
    
    public static String nom(int adr) {
        String tableauNom[] = {"Fabien", "Romain", "Floran" , "Guillaume", "Romuald", "Clément", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
        return tableauNom[adr-1];
    }
}

package tirage;

import java.io.*;
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
        try{
            InputStream flux=new FileInputStream("precedent.txt"); 
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            while ((ligne=buff.readLine())!=null){
                    System.out.println(ligne);
                    regex();
            }
            buff.close(); 
        }		
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void regex() {
        pattern1 = Pattern.compile("((\\w{1,9})\\;)");
        matcher1 = pattern1.matcher(ligne);
        
        int i = 0;
        tab_file = new Structure[4];
        while(matcher1.find()) {
            tab_file[i] = new Structure(correspondance(matcher1.group(2)), matcher1.group(2));
            //System.out.println(matcher1.group(2)+matcher1.group(3));
            i++;
        }
    }
    
    public int correspondance(String nom) {
        String data[] = {"Fabien", "Romain", "Floran" , "Guillaume", "Romuald", "Clement", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
        int i = 1;
        for (String s : data) {
            if(s.equals(nom)) {
                return i;
            }
            i++;
        }
        return 0;
    }
    
    public String view_tab() {
        
        String concat = "";
        for(int e=0; e<4; e++) {
            concat = concat+tab_file[e].return_nb_tirage()+",";
        }
        System.out.println(concat);
        return concat;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tirage;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;
import java.util.List;
import java.util.Iterator;
import org.apache.commons.lang3.*;

/**
 *
 * @author Romuald
 */
public class XML {

    Element racine;
    String data[] = {"Fabien", "Romain", "Florent" , "Guillaume", "Romuald", "Clement", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
    String[][] save_tab;
    
    //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
    org.jdom2.Document document = new Document(racine);

    public XML()
    {
        //On crée une instance de SAXBuilder
       SAXBuilder sxb = new SAXBuilder();
       try
       {
          //On crée un nouveau document JDOM avec en argument le fichier XML
          //Le parsing est terminé ;)
          document = sxb.build(new File("sauvegarde.xml"));
       }
       catch(Exception e){}

       //On initialise un nouvel élément racine avec l'élément racine du document.
       racine = document.getRootElement();

    }
    
    public void read() {
        SAXBuilder sxb = new SAXBuilder();
        try
        {
           //On crée un nouveau document JDOM avec en argument le fichier XML
           //Le parsing est terminé ;)
           document = sxb.build(new File("sauvegarde.xml"));
        }
        catch(Exception e){}

        //On initialise un nouvel élément racine avec l'élément racine du document.
        racine = document.getRootElement();
    }

    public void add(String anim, String secre, String scrib, String gest)
    {
        List listEtudiants = racine.getChildren("prosit");
        //On crée un Iterator sur notre liste
        Iterator i = listEtudiants.iterator();
        int last_prosit=0;
        
        while(i.hasNext())
        {
            i.next();
            last_prosit++;
        }
        
        Element etudiant = new Element("prosit");
        racine.addContent(etudiant);

        //On crée un nouvel Attribut classe et on l'ajoute à etudiant
        //grâce à la méthode setAttribute
        Attribute classe = new Attribute("classe", "P"+Integer.toString(last_prosit+1));
        etudiant.setAttribute(classe);

        //On crée un nouvel Element nom, on lui assigne du texte
        //et on l'ajoute en tant qu'Element de etudiant
        Element animateur = new Element("animateur");
        Element secretaire = new Element("secretaire");
        Element scribe = new Element("scribe");
        Element gestionnaire = new Element("gestionnaire");
        
        System.out.println(anim + " " + secre + " " + scrib + " " + gest);
        
        animateur.setText(anim);
        secretaire.setText(secre);
        scribe.setText(scrib);
        gestionnaire.setText(gest);
        
        etudiant.addContent(animateur);
        etudiant.addContent(secretaire);
        etudiant.addContent(scribe);
        etudiant.addContent(gestionnaire);
        
        enregistre("sauvegarde.xml");
    }

    public String list_animateur()
    {
        //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
        List listEtudiants = racine.getChildren("prosit");
        String concat_anim = "";
        //On crée un Iterator sur notre liste
        Iterator i = listEtudiants.iterator();
        while(i.hasNext())
        {
           //On recrée l'Element courant à chaque tour de boucle afin de
           //pouvoir utiliser les méthodes propres aux Element comme :
           //sélectionner un nœud fils, modifier du texte, etc...
           Element courant = (Element)i.next();
           
           concat_anim = concat_anim + courant.getChild("animateur").getText();
           //On affiche le nom de l’élément courant
           //System.out.println(courant.getChild("animateur").getText());
        }
        return concat_anim;
    }
    
    public String list_secretaire()
    {
        //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
        List listEtudiants = racine.getChildren("prosit");
        String concat_secre = "";
        //On crée un Iterator sur notre liste
        Iterator i = listEtudiants.iterator();
        while(i.hasNext())
        {
           //On recrée l'Element courant à chaque tour de boucle afin de
           //pouvoir utiliser les méthodes propres aux Element comme :
           //sélectionner un nœud fils, modifier du texte, etc...
           Element courant = (Element)i.next();
           
           concat_secre = concat_secre + courant.getChild("secretaire").getText();
           //On affiche le nom de l’élément courant
           //System.out.println(courant.getChild("animateur").getText());
        }
        return concat_secre;
    }
    
    public String list_scribe()
    {
        //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
        List listEtudiants = racine.getChildren("prosit");
        String concat_scribe = "";
        //On crée un Iterator sur notre liste
        Iterator i = listEtudiants.iterator();
        while(i.hasNext())
        {
           //On recrée l'Element courant à chaque tour de boucle afin de
           //pouvoir utiliser les méthodes propres aux Element comme :
           //sélectionner un nœud fils, modifier du texte, etc...
           Element courant = (Element)i.next();
           
           concat_scribe = concat_scribe + courant.getChild("scribe").getText();
           //On affiche le nom de l’élément courant
           //System.out.println(courant.getChild("animateur").getText());
        }
        return concat_scribe;
    }
    
    public String list_gestionnaire()
    {
        //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
        List listEtudiants = racine.getChildren("prosit");
        String concat_gest = "";
        //On crée un Iterator sur notre liste
        Iterator i = listEtudiants.iterator();
        while(i.hasNext())
        {
           //On recrée l'Element courant à chaque tour de boucle afin de
           //pouvoir utiliser les méthodes propres aux Element comme :
           //sélectionner un nœud fils, modifier du texte, etc...
           Element courant = (Element)i.next();
           
           concat_gest = concat_gest + courant.getChild("gestionnaire").getText();
           //On affiche le nom de l’élément courant
           //System.out.println(courant.getChild("animateur").getText());
        }
        return concat_gest;
    }

    public void affiche_XML()
    {
       try
       {
          //On utilise ici un affichage classique avec getPrettyFormat()
          XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
          sortie.output(document, System.out);
       }
       catch (java.io.IOException e){}
    }
    
    public void save_tab()
    {
        //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
         List listEtudiants = racine.getChildren("prosit");

         //On crée un Iterator sur notre liste
         Iterator i = listEtudiants.iterator();
         save_tab = new String[((racine.getContentSize() - 1) / 2)][8];
         int e = 0;
         
         while(i.hasNext())
         {
            //On recrée l'Element courant à chaque tour de boucle afin de
            //pouvoir utiliser les méthodes propres aux Element comme :
            //sélectionner un nœud fils, modifier du texte, etc...
            Element courant = (Element)i.next();
            
            //Sauvegarde des noms dans un tableau
            save_tab[e][0] = name_to_nb_string(courant.getChild("animateur").getText());
            save_tab[e][1] = courant.getChild("animateur").getText();
            save_tab[e][2] = name_to_nb_string(courant.getChild("secretaire").getText());
            save_tab[e][3] = courant.getChild("secretaire").getText();
            save_tab[e][4] = name_to_nb_string(courant.getChild("scribe").getText());
            save_tab[e][5] = courant.getChild("scribe").getText();
            save_tab[e][6] = name_to_nb_string(courant.getChild("gestionnaire").getText());
            save_tab[e][7] = courant.getChild("gestionnaire").getText();
            
            //On affiche le nom de l’élément courant
            System.out.println(courant.getChild("animateur").getText() + " " + courant.getChild("secretaire").getText() + " " +
                    courant.getChild("scribe").getText() + " " + courant.getChild("gestionnaire").getText());
            e++;
         }
    }
    
    public String nb_to_name(int number) {
        return data[number];
    }
    
    public int name_to_nb(String nom) {
        int i = 1;
        for (String s : data) {
            if(s.equals(nom)) {
                return i;
            }
            i++;
        }
        return 0;
    }
    
    public String last_nb_save_tab() {
        int max = ((racine.getContentSize() - 1) / 2);
        //System.out.println(save_tab[max-1][0] + "," + save_tab[max-1][2] + "," + save_tab[max-1][4] + "," + save_tab[max-1][6]);
        return save_tab[max-1][0] + "," + save_tab[max-1][2] + "," + save_tab[max-1][4] + "," + save_tab[max-1][6];
    }
    
    //Pas utile pour le moment
    public void view_save_tab()
    {
        int max = ((racine.getContentSize() - 1) / 2);
        
        for (int i=0; i < max; i++) {
            System.out.println(save_tab[i][0] + " " + save_tab[i][1] + " " + save_tab[i][2] + " " + save_tab[i][3] + " " +
                    save_tab[i][4] + " " + save_tab[i][5] + " " + save_tab[i][6] + " " + save_tab[i][7]);
        }
    }
    
    public String name_to_nb_string(String nom) {
        int i = 1;
        for (String s : data) {
            if(s.equals(nom)) {
                return Integer.toString(i);
            }
            i++;
        }
        return "";
    }

    public int freq_anim(int nb_name) {
        //System.out.println(StringUtils.countMatches(list_animateur(), nb_to_name(nb_name)));
        return StringUtils.countMatches(list_animateur(), nb_to_name(nb_name));
    }
    
    public int freq_secret(int nb_name) {
        //System.out.println(StringUtils.countMatches(list_animateur(), nb_to_name(nb_name)));
        return StringUtils.countMatches(list_secretaire(), nb_to_name(nb_name));
    }
    
    public int freq_scribe(int nb_name) {
        //System.out.println(StringUtils.countMatches(list_animateur(), nb_to_name(nb_name)));
        return StringUtils.countMatches(list_scribe(), nb_to_name(nb_name));
    }
    
    public int freq_gest(int nb_name) {
        //System.out.println(StringUtils.countMatches(list_animateur(), nb_to_name(nb_name)));
        return StringUtils.countMatches(list_gestionnaire(), nb_to_name(nb_name));
    }
    
    public int moins_anim() {
        String[][] comp = new String[12][2];

        for(int i = 0; i < 12; i++) {
            comp[i][0] = Integer.toString(freq_anim(i));
            comp[i][1] = data[i];
        }
        
        Arrays.sort(comp, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = comp[0][1];
        int rep_int = name_to_nb(rep);
        System.out.println("Moins Animateur = "+rep+" / Numéro = "+rep_int);
        return rep_int;
    }
    
    public void test(String[][] strArray) {
        for(int i = 0; i < 12; i++) {
            System.out.println(strArray[i][0]);
            System.out.println(strArray[i][1]);
       }
    }
    
    public int moins_secret() {
        String[][] comp = new String[12][2];

        for(int i = 0; i < 12; i++) {
            comp[i][0] = Integer.toString(freq_secret(i));
            comp[i][1] = data[i];
        }
        
        Arrays.sort(comp, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = comp[0][1];
        int rep_int = name_to_nb(rep);
        System.out.println("Moins Secrétaire = "+rep+" / Numéro = "+rep_int);
        return rep_int;
    }
    
    public int moins_scribe() {
        String[][] comp = new String[12][2];

        for(int i = 0; i < 12; i++) {
            comp[i][0] = Integer.toString(freq_scribe(i));
            comp[i][1] = data[i];
        }
        
        Arrays.sort(comp, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = comp[0][1];
        int rep_int = name_to_nb(rep);
        System.out.println("Moins Scribe = "+rep+" / Numéro = "+rep_int);
        return rep_int;
    }
    
    public int moins_gest() {
        String[][] comp = new String[12][2];

        for(int i = 0; i < 12; i++) {
            comp[i][0] = Integer.toString(freq_gest(i));
            comp[i][1] = data[i];
        }
        
        Arrays.sort(comp, new Comparator<String[]>() {
            @Override
            public int compare(final String[] entry1, final String[] entry2) {
                final String time1 = entry1[0];
                final String time2 = entry2[0];
                return time1.compareTo(time2);
            }
        });
        
        String rep = comp[0][1];
        int rep_int = name_to_nb(rep);
        System.out.println("Moins Gestionnaire = "+rep+" / Numéro = "+rep_int);
        return rep_int;
    }
    
    public void enregistre(String fichier)
    {
       try
       {
          //On utilise ici un affichage classique avec getPrettyFormat()
          XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
          //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
          //avec en argument le nom du fichier pour effectuer la sérialisation.
          sortie.output(document, new FileOutputStream(fichier));
       }
       catch (java.io.IOException e){}
    }
}
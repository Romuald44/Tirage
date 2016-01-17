/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tirage;
import java.io.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author Romuald
 */
public class XML {

    static Element racine;
    static String data[] = {"Fabien", "Romain", "Florent" , "Guillaume", "Romuald", "Clement", "Alexandre" , "Eva", "Reynald", "Luc", "Quentin" , "Paul"};
    static String[][] save_tab;
    
    //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
    static org.jdom2.Document document = new Document(racine);

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

    public void add(String prosit, String anim, String secre, String scrib, String gest)
    {
         Element etudiant = new Element("prosit");
         racine.addContent(etudiant);

         //On crée un nouvel Attribut classe et on l'ajoute à etudiant
         //grâce à la méthode setAttribute
         Attribute classe = new Attribute("classe", prosit);
         etudiant.setAttribute(classe);

         //On crée un nouvel Element nom, on lui assigne du texte
         //et on l'ajoute en tant qu'Element de etudiant
         Element animateur = new Element("animateur");
         Element secretaire = new Element("secretaire");
         Element scribe = new Element("scribe");
         Element gestionnaire = new Element("gestionnaire");

         animateur.setText(anim);
         secretaire.setText(secre);
         scribe.setText(scrib);
         gestionnaire.setText(gest);

         etudiant.addContent(animateur);
         etudiant.addContent(secretaire);
         etudiant.addContent(scribe);
         etudiant.addContent(gestionnaire);
    }

    public void affiche_animateur()
    {
       //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
       List listEtudiants = racine.getChildren("prosit");

       //On crée un Iterator sur notre liste
       Iterator i = listEtudiants.iterator();
       while(i.hasNext())
       {
          //On recrée l'Element courant à chaque tour de boucle afin de
          //pouvoir utiliser les méthodes propres aux Element comme :
          //sélectionner un nœud fils, modifier du texte, etc...
          Element courant = (Element)i.next();
          //On affiche le nom de l’élément courant
          System.out.println(courant.getChild("animateur").getText());
       }
    }
    
    public void affiche_secretaire()
    {
       //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
       List listEtudiants = racine.getChildren("prosit");

       //On crée un Iterator sur notre liste
       Iterator i = listEtudiants.iterator();
       while(i.hasNext())
       {
          //On recrée l'Element courant à chaque tour de boucle afin de
          //pouvoir utiliser les méthodes propres aux Element comme :
          //sélectionner un nœud fils, modifier du texte, etc...
          Element courant = (Element)i.next();
          //On affiche le nom de l’élément courant
          System.out.println(courant.getChild("secretaire").getText());
       }
    }
    
    public void affiche_scribe()
    {
       //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
       List listEtudiants = racine.getChildren("prosit");

       //On crée un Iterator sur notre liste
       Iterator i = listEtudiants.iterator();
       while(i.hasNext())
       {
          //On recrée l'Element courant à chaque tour de boucle afin de
          //pouvoir utiliser les méthodes propres aux Element comme :
          //sélectionner un nœud fils, modifier du texte, etc...
          Element courant = (Element)i.next();
          //On affiche le nom de l’élément courant
          System.out.println(courant.getChild("scribe").getText());
       }
    }
    
    public void affiche_gestionnaire()
    {
       //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
       List listEtudiants = racine.getChildren("prosit");

       //On crée un Iterator sur notre liste
       Iterator i = listEtudiants.iterator();
       while(i.hasNext())
       {
          //On recrée l'Element courant à chaque tour de boucle afin de
          //pouvoir utiliser les méthodes propres aux Element comme :
          //sélectionner un nœud fils, modifier du texte, etc...
          Element courant = (Element)i.next();
          //On affiche le nom de l’élément courant
          System.out.println(courant.getChild("gestionnaire").getText());
       }
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
            /*System.out.println(courant.getChild("animateur").getText() + " " + courant.getChild("secretaire").getText() + " " +
                    courant.getChild("scribe").getText() + " " + courant.getChild("gestionnaire").getText());*/
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
    
    public String view_nb_save_tab() {
        int max = ((racine.getContentSize() - 1) / 2);
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
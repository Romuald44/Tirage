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

   //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
    static org.jdom2.Document document = new Document(racine);

    public XML(String[] args)
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

    void add(String prosit, String anim, String secre, String scrib, String gest)
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

    void afficheALL()
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

    void affiche()
    {
       try
       {
          //On utilise ici un affichage classique avec getPrettyFormat()
          XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
          sortie.output(document, System.out);
       }
       catch (java.io.IOException e){}
    }

     void enregistre(String fichier)
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
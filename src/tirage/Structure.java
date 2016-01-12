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
public class Structure {
   int nb_tirage;
   String firstname;
   
   public Structure(String nb_tirage, String firstname) {
       this.nb_tirage = Integer.parseInt(nb_tirage);
       this.firstname = firstname;
   }
   
   public int return_nb_tirage() {
	return this.nb_tirage;
   }
   
   public String return_name() {
	return this.firstname;
   }
}
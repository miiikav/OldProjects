/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkuainetest;

/**
 *
 * @author Tuomo
 */
public class Alkuaine {
    
   /* 
    * Attribuutit.
    *
    */

   // merkki
   private String merkki;

   // numero
   private int numero;

   /* 
    * Aksessorit.
    *
    */
   
       
   public String merkki() {  
       return merkki;
       }

   
   public void merkki(String e) {
       if (e != null && (e.length() > 0 && e.length() <=3)) {
           merkki = e;
       }

   }
   public int numero() {
       return numero;
       
   }
   
   
   public void numero(int type2) {
       if (type2 >= 1 && type2 <=118) {
           numero=type2;
       }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pullatesti;

import static java.lang.Boolean.parseBoolean;


/**
 *
 * @author Tuomo
 */
public class Pulla {
    
   /* 
    * Attribuutit.
    *
    */

   // pullan paino
   private double paino;

   // Onko pulla laktoositon
   private boolean laktoositon;

   /* 
    * Aksessorit.
    *
    */
      
   public double paino() {
       return paino;
   }

   
   public void paino(double e) {
       if (e >= 0 && e <=1000) {
           paino = e;

       }
   }
   public boolean laktoositon() {
       return laktoositon;
       
   }
   
   
   public void laktoositon(boolean type2) {
        laktoositon=type2;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kolikonheitto;

/**
 *
 * @author Oppilas
 */
public class Kolikonheitto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sata=0;
        int kruuna=0;
        int klaava=0;
        do {
   double d = Math.random();
   sata=sata+1;
   if(d < 1.0/2.0){
 System.out.println("Kruuna");
 kruuna=kruuna+1;
}
   else{
  System.out.println("Klaava");
  klaava=klaava+1;
   }
   }while (sata<100);
        System.out.println("Kruuna tuli " + kruuna + " kertaa ja Klaava " + klaava + " kertaa");
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array2dprinter;

/**
 *
 * @author Tuomo
 */
public class Array2DPrinter {

   /* Tulostetaan kaksiulotteisen taulukon t alkiot näytölle.
    * Taulukko oletetaan suorakaiteen muotoiseksi.
    */
   public static void tulosta(char[][] t) {
      // Tulostetaan vain, jos taulukolle on varattu muistia.
      if (t != null) {
         // Rivien ja sarakkeiden lukumäärät.
         int rivlkm = t.length;
         int sarlkm = t[0].length;

         // Tulostetaan rivit.
         for (int rivi = 0; rivi < rivlkm; rivi++) {
            // Tulostetaan rivi.
            for (int sarake = 0; sarake < sarlkm; sarake++)
               System.out.print(t[rivi][sarake]);
            // Rivin lopussa vaihdetaan riviä.
            System.out.println();
         }
      }
   }

   /* Palauttaa väliviivan.
    */
   public static String annaValiviiva() {
      // Palautetaan väliviiva.
      return "----------";
   }
   
   public static void main(String[] args) {
      // Esitellään ja luodaan taulukoita.
      char[][] taulu1 = null;
      char[][] taulu2 = { { 'a' } };
      char[][] taulu3 = { { 'a', 'b', 'c' } };
      char[][] taulu4 =  { { 'a' }, { 'b' }, { 'c' } };
      char[][] taulu5 =  { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };

      // Metodikutsuja.
      System.out.println(annaValiviiva());
      tulosta(taulu1);
      System.out.println(annaValiviiva());
      tulosta(taulu2);
      System.out.println(annaValiviiva());
      tulosta(taulu3);
      System.out.println(annaValiviiva());
      tulosta(taulu4);
      System.out.println(annaValiviiva());
      tulosta(taulu5);
      System.out.println(annaValiviiva());
   } 
}
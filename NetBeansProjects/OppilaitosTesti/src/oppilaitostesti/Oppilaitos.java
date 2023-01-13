/* 
 * Viikkoharjoitus 1, teht�v� 2.
 *  
 * Olio-ohjelmoinnin perusteet, kev�t 2018, Jorma Laurikkala.
 *
 * Mallinnetaan hyvin yleisell� tasolla oppilaitosta.
 *
 */
package oppilaitostesti;
public class Oppilaitos {

   /* 
    * Attribuutin sallitut arvot julkisina vakioina.
    *
    * Vakiot on esitelty public-m��reell�, koska niist� voi olla hy�ty�
    * luokan ulkopuolella. Esittelyss� on k�ytetty static-m��rett�,
    * jolla vakiot saadaan k�ytt��n nopeasti ilman oliota.
    *
    */

   // Esikoulu.
   public static final int ESIASTE = 0;

   // Peruskoulu.
   public static final int PERUSASTE = 1;

   // Lukio ja ammattikoulu.
   public static final int TOINENASTE = 2;

   // Yliopisto ja ammattikorkeakoulu.
   public static final int KORKEAASTE = 3;

   /* 
    * Attribuutit.
    *
    */

   // Oppilaitoksen opiskelijoiden lukum��r�.
   private int opiskelijoita;

   // Oppilaitoksen aste.
   private int aste;

   /* 
    * Aksessorit.
    *
    */

   public int opiskelijoita() {
      return opiskelijoita;
   }

   public void opiskelijoita(int e) {
      if (e >= 0) {
         opiskelijoita = e;
      }
   }

   public void aste(int asteet) {
      if (asteet >= 0 && asteet <4) {
         aste = asteet;
      }
   }

   public int aste() {
      return aste;
   }
}

/*
* Viimeisin muutos 1.9.2013, Risto Hovila
*/
package at3.apu;
import java.util.Locale;
import java.util.Scanner;
/**
* Lukija-luokka merkkijonojen lukemiseen näppäimistöltä.
* @author Risto Hovila
* @version 1.2
*/
public class Lukija {
 /**
 * Metodi kokonaisluvun lukemiseksi.
 * @param kysymys Merkkijono, joka tulostetaan ennen luvun syöttöä
 * @return käyttäjän antama kokonaisluku, mikäli lukua
 * ei saada luettua, palautetaan arvo 0.
 */
 public static int lueInt(String kysymys){
 Scanner sc = new Scanner(System.in);
 System.out.println(kysymys);
 int i;
 try{
 i = sc.nextInt();
 }
 catch(Exception e){
 System.out.println("************ VIESTI LUKIJALTA *************");
 System.out.println("* Tapahtui virhe: lukua ei saatu luettua! *");
 System.out.println("* Annoitko varmasti kokonaisluvun? *");
 System.out.println("* Arvoksi asetetaan 0 *");
 System.out.println("*******************************************");
 i=0;
 }
 return i;
 }
 /**
 * Metodi liukuluvun lukemiseksi.
 * @param kysymys Merkkijono, joka tulostetaan ennen luvun syöttöä.
 * @return käyttäjän antama liukuluku, mikäli lukua
 * ei saada luettua, palautetaan arvo 0.0.
 */
 public static double lueDouble(String kysymys){
 Scanner sc = new Scanner(System.in);
 sc.useLocale(Locale.US);
 System.out.println(kysymys);
 double a;
 try{
 a = sc.nextDouble();
 }
 catch(Exception e){
 System.out.println("************ VIESTI LUKIJALTA *************");
 System.out.println("* Tapahtui virhe: lukua ei saatu luettua! *");
 System.out.println("* Annoitko varmasti liukuluvun? *");
 System.out.println("* Arvoksi asetetaan 0.0 *");
 System.out.println("*******************************************");
 a=0.0;
 }
 return a;}
 /**
 * Metodi merkkijonon lukemiseksi.
 * @param kysymys Merkkijono, joka tulostetaan ennen luvun syöttöä
 * @return käyttäjän antama merkkijono, mikäli jonoa
 * ei saada luettua, palautetaan arvo "kissa".
 */
 public static String lueString(String kysymys){
 System.out.println(kysymys);
 Scanner sc = new Scanner(System.in, "ISO-8859-1");
 String jono;
 try{
 jono = sc.nextLine();
 }
 catch(Exception e){
 System.out.println("************ VIESTI LUKIJALTA *************");
 System.out.println("* Tapahtui virhe: lukua ei saatu luettua! *");
 System.out.println("* Kokeile uudestaan! *");
 System.out.println("* Arvoksi asetetaan \"kissa\" *");
 System.out.println("*******************************************");
 jono="kissa";
 }
 return jono;
 }
 /**
 * Testataan metodien toimivuutta.
 * @param args the command line arguments
 */
 public static void main(String[] args) {
 int i;
 i = lueInt("Anna kokonaisluku:");
 System.out.println("Luku oli: "+i);
 double a;
 a = lueDouble("Anna liukuluku:");
 System.out.println("Luku oli: "+a);
 String jono;
 jono = lueString("Anna merkkijono:");
 System.out.println("Jono oli: "+jono);
 }
}
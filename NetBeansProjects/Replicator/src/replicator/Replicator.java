/*
 *
 *  Operaatio muodostaa parametrinaan samastaan merkkijonosta (String) uuden merkkijonon,
 *  jossa alkuperäinen merkkijono toistuu siten, että toistot on erotettu toisistaan pilkulla ja yhdellä välilyönnillä.
 *  Myös toistojen lukumäärä (int) välitetään operaatiolle parametrina.
 *  Operaatio palauttaa tyhjän merkkijonon "", jos toistojen lukumäärä on kahta pienempi. 
 * 
 */
//Nämä olivat NetBeansia varten
package replicator;
import java.util.*;
/**
 *
 * @author Tuomo Ikävalko
 */
public class Replicator {
    //paluuarvo on tässä, jotta sekä main,että Replikointi Operaattori voi käyttää sitä.
    private static String paluuarvo="";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Nämä olivat NetBeansia varten
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I replicate strings.");
        //käyttäjältä luetaan kaksi syötettä
        System.out.println("Please, enter a string:");
        //Nämä olivat NetBeansia varten(In luokka ei tunnu toiminan NetBeansissa)
        String sana = scan.next();
        //String sana = In.readString();
        System.out.println("Please, enter the number of replications:");
        //Nämä olivat NetBeansia varten(In luokka ei tunnu toiminan NetBeansissa)
        int kertaa = scan.nextInt();
        //int kertaa = In.readInt();
        //Kutsutaan operaattoria.
        Replikointi(sana,kertaa);
        //virheellisille syötteille
        if(paluuarvo.equals("")){
            System.out.println("Error!");
        }
        //valmis merkkijono päätyy tänne
        else{
            System.out.println(paluuarvo);
        }
    }

    public static void Replikointi(String sana,int kertaa) {
        int indeksiarvo=0;
        //hoidetaan virheelliset syötteet heti pois
        if(kertaa<2){
            paluuarvo="";
        }
        else{
            //kertaa-1, koska en halua pilkkua ja välilyöntiä viimeisen sanan jälkeen
            while(kertaa-1>indeksiarvo){
                paluuarvo=paluuarvo+sana+", ";
                indeksiarvo++;
            }
            //viimeistä sanaa varten
            paluuarvo=paluuarvo+sana;
        }
    }
    
}

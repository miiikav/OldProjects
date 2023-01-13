/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matikkaa;

import at3.apu.Lukija;
/**
 *
 * @author Oppilas
 */
public class Matikkaa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Math.max
    double luku = Lukija.lueDouble("Ensimmäinen Luku");
    double luku2 = Lukija.lueDouble("Toinen Luku");
    double tulos = Math.max(luku , luku2);
    System.out.println(tulos);
        //Math.abs
    double abs = Lukija.lueDouble("liukuluku");
    double itseisarvo = Math.abs(abs);
    System.out.println(itseisarvo);
        //Math.round
    double round = Lukija.lueDouble("liukuluku");
    double koko = Math.round(round);
    System.out.println(koko);
        //Math.pov 
    double d = Lukija.lueDouble("liukuluku");
    int k = Lukija.lueInt("kokonaisluku");
    double potenssi = Math.pow(d , k);
    System.out.println(potenssi);
        // Math.PI
    double pii = Math.PI;
    System.out.println("Piin arvo on "+pii);
        // Math.sin(), Math.cos(), Math.tan()
    double sincostan = Lukija.lueDouble("liukuluku");
    double sin = Math.sin(sincostan);
    double cos = Math.cos(sincostan);
    double tan = Math.tan(sincostan);
    System.out.println(sin);
    System.out.println(cos);
    System.out.println(tan);
        //Math.toRadians
    double sincostan2 = Lukija.lueDouble("liukuluku");
    sincostan2 = Math.toRadians(sincostan2);
    double sin2 = Math.sin(sincostan2);
    double cos2 = Math.cos(sincostan2);
    double tan2 = Math.tan(sincostan2);
    System.out.println(sin2);
    System.out.println(cos2);
    System.out.println(tan2);
      
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tee.pkgdo.pkgwhile.lausetta.käyttäen.ohjelma;
import at3.apu.Lukija;
/**
 *
 * @author Oppilas
 */
public class TeeDoWhileLausettaKäyttäenOhjelma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    String i;
    int e = 0;
    i = Lukija.lueString("Anna merkkijono, jonka haluat tulostaa:");
    int a = Lukija.lueInt("Montako kertaa tulostetaan?");
    do{
    System.out.println(i);
    e=e+1;
    } while(e<a);
    }
            
}
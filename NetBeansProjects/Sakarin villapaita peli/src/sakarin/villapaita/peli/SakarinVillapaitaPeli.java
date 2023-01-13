/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sakarin.villapaita.peli;

import at3.apu.Lukija;

/**
 *
 * @author Oppilas
 */
public class SakarinVillapaitaPeli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int villapaita = Lukija.lueInt("Pue Sakarille villapaita 1=Kyllä 2=Ei");
if (villapaita==1 || villapaita==2){
    System.out.println("Hi hi hii kutittaa. Voitit Pelin!");
}
    else {
    System.out.println("Hävisit Pelin");
}
    }}
    
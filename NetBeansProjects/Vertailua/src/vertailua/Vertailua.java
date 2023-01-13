/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vertailua;

import at3.apu.Lukija;
/**
 *
 * @author Oppilas
 */
public class Vertailua {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

int luku = Lukija.lueInt("Anna 1 tai 2");
if (luku==1 || luku==2){
    System.out.println("Hienoa, osasit!");
}
    else {
    System.out.println("Et tainnut ymmärtää pyyntöäni... Mokoma Lasse!");
}
    }}
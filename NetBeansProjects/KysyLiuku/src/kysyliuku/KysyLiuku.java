/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kysyliuku;

import at3.apu.Lukija;

/**
 *
 * @author Oppilas
 */
public class KysyLiuku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   double i;
    i = Lukija.lueDouble("Anna liukuluku: ");
    System.out.println("Lukusi on " + i);
    }
    
}

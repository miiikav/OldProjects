/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kysykoko;
import at3.apu.Lukija;
/**
 *
 * @author Oppilas
 */
public class Kysykoko {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int i;
    i = Lukija.lueInt("Anna kokonaisluku: ");
    System.out.println("Lukusi on " + i);
    i = Lukija.lueInt("Anna toinen luku: ");
    System.out.println("Lukusi on " + i);
    
    }
}
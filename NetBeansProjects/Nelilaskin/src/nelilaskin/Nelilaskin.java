/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nelilaskin;

import at3.apu.Lukija;
/**
 *
 * @author Oppilas
 */
public class Nelilaskin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int luku = Lukija.lueInt("Annna luku");
    int luku2 = Lukija.lueInt("Annna luku");
    int test = Lukija.lueInt("Valitse laskutoimitus: (1)+ (2)- (3)* (4)/");
switch (test)
{
 case 1:
 System.out.println(luku+luku2);
 break;
 case 2:
 System.out.println(luku-luku2);
 break;
 case 3:
 System.out.println(luku*luku2);
 break;
 case 4:
 System.out.println(luku*1.0/luku2*1.0);
 break;
 default:
 System.out.println("ERROR!");
}
    }
    
}
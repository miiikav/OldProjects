/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package havisitniukasti;

import at3.apu.Lukija;

/**
 *
 * @author Oppilas
 */
public class HavisitNiukasti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int i;
    i = Lukija.lueInt("Arvaa luku: ");
    System.out.println("Minun lukuni on. " + (i+1) + " Hävisit!");
    }
    
}

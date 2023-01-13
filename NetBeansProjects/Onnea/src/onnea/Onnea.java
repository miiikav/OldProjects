/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onnea;

import at3.apu.Lukija;

/**
 *
 * @author Oppilas
 */
public class Onnea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int i;
    i = Lukija.lueInt("Kuinka vanha olet? ");
    System.out.println("Olet " + i + " vuotta!");
   for (int o = i; o>0; o = o-1)
   
        System.out.println("Onnea!");
    }
    
}

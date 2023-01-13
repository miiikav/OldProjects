/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package posneg;

import at3.apu.Lukija;

/**
 *
 * @author Oppilas
 */
public class PosNeg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int i;
    i = Lukija.lueInt("Anna luku:");
    if (i<0)
    System.out.println("Lukusi on negatiivinen");
    else if (i==0)
    System.out.println("Lukusi on nolla");
    else
    System.out.println("Lukusi on Positiivinen");
    }
}
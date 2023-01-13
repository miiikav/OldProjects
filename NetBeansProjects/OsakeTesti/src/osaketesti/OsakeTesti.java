/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osaketesti;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class OsakeTesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I test shares.");
        System.out.println("Please, enter the share price:");
        double num=In.readDouble();
        System.out.println("Please, enter the name of the company:");
        String name=In.readString();
        Osake testi = new Osake();
        // Asettavien metodien kutsut.
        testi.arvo(num);
        testi.yhtio(name);
        // Lukevien metodien kutsut.
        double nnum=testi.arvo();
        String nname=testi.yhtio();
        System.out.println("State is "+nnum+" and "+nname+"." );
    }
    
}

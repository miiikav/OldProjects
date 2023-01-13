/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira18_01;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author tuomo
 */
public class Tira18_01_2b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         if(args.length==1){
            try { //Yrittää löytää annettu tekstitiedosto
                File txtfile= new File(args[0]);
            Scanner lukija = new Scanner(txtfile);
            int currentMin=Integer.MAX_VALUE;
            while(lukija.hasNextInt()) { //Lukija tarkistaa seuraavan luvun
                int num = lukija.nextInt();
                if(num<currentMin){ //Jos luku on pienempi kuin suurin luku, siitä tulee pienin luku
                    currentMin=num;
                }
            }
            System.out.println(currentMin); //Lopuksi tulostetaan pienin luku
            
            } catch (FileNotFoundException ex) {
                //Tiedostoa ei löydetty tulostetaan viesti ja lopetetaan ohjelma
                System.out.println("Invalid command-line argument!");
            }
            System.out.println("Bye, see you soon.");
        }
        else{
            //Tiedostoa ei löydetty tulostetaan viesti ja lopetetaan ohjelma
            System.out.println("Invalid command-line argument!");
            System.out.println("Bye, see you soon.");
        }
    }
    
}

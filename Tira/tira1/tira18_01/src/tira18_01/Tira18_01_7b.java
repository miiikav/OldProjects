/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira18_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author tuomo
 */
public class Tira18_01_7b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         if(args.length==1){
            try { //Yrittää löytää annettu tekstitiedosto
                File txtfile= new File(args[0]);
            Scanner lukija = new Scanner(txtfile);
            double maxValue = 0;
            int maxCount=0;
            while(lukija.hasNextInt()) { //Lukija tarkistaa seuraavan luvun
                int i = lukija.nextInt();
                int count = 0;
                while(lukija.hasNextInt()) {
                    int j = lukija.nextInt();
                    if (j == i){
                        count++;
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        maxValue = i;
                    }
                }
            }
            System.out.println(maxValue); //Lopuksi tulostetaan moodi
            
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

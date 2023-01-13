/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira18_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tuomo
 */
public class Tira18_01_7a {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) {
 
      if(args.length==1){
            try { //Yrittää löytää annettu tekstitiedosto
                File txtfile= new File(args[0]);
                int Median = Median(txtfile);
                System.out.println(Median);
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


    public static int Median(File txtfile) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        Scanner lukija = new Scanner(txtfile);
            int numberOfElements = lukija.nextInt();

      int[] numbers = new int[numberOfElements];

      for (int i = 0; i < numberOfElements; ++i)
      {
        numbers[i] = lukija.nextInt();
      }

      Arrays.sort(numbers);

      int medianIndex = ((numberOfElements % 2 == 0 ?
        numberOfElements : numberOfElements + 1) >> 1) - 1;
      int fin = numbers[medianIndex];
      return fin;
  
    }
    
}
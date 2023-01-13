/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hirsipuu;

import java.util.Scanner;
/**
 *
 * @author Oppilas
 */
public class Hirsipuu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    String sana;  
    Scanner scan = new Scanner(System.in); 
    
    
    
    System.out.println("Anna sana"); 
    sana = scan.next();
    System.out.println("Kuinka monta arvausta:"); 
    int arvaukset = scan.nextInt();
    int pituus = sana.length();
    String [] taulukko = new String [pituus];
    for (int i=0; i<taulukko.length; i++){
      taulukko [i] = "-";
      }
    boolean b = true;
    while (arvaukset>0) {
        String arvaus;
        System.out.println("Anna kirjain:");
        arvaus = scan.next();
        b = true;
        for (int q=0; q<taulukko.length; q++) {
            System.out.println(taulukko [q]);
            char kirjain = sana.charAt(q);
            char kirjain2 = arvaus.charAt(q);
            if (kirjain == kirjain2){
               b = false;
               taulukko [q] = arvaus;          
            }
            else {
                  b=true;
                  arvaukset=arvaukset-1;
                  }
        }
         while (arvaukset<=0){
           System.out.println("Arvaukset loppuivat. \n Hävisit pelin");
           }
      }
    }
}
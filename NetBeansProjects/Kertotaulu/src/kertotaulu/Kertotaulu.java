/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kertotaulu;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Kertotaulu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Moi! Tulostan kertotaulun.");
        System.out.println("Anna luku:");
        int luku=scan.nextInt();
        int kerroin=1;
        while(kerroin<=10){
        

        int tulo=kerroin*luku;
        System.out.println(kerroin + " x " + luku + " = " + tulo);
        kerroin=kerroin+1;
        }
        
    }
    
}

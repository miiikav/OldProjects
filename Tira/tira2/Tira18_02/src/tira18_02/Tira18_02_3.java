/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira18_02;

import java.util.Scanner;

/**
 *
 * @author tuomo
 */
public class Tira18_02_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hei, Anna posiitiivinen kokonaisluku");
        double n=scan.nextInt();
        System.out.println("a) "+6*n+"\n" + "b) "+3*Math.log(n)+"\n" + "c) "+Math.sqrt(n)*Math.log(n));        //a) 6n b) 3 log n c) vn log n
        System.out.println("d) "+5*Math.pow(n, 2)+"\n" + "e) "+Math.sqrt(n)+"\n" + "f) "+42);                  //d) 5n^2 e) vn f) 42
        System.out.println("g) "+Factoral(n)+"\n" + "h) "+7*Math.log(Math.log(n))+"\n" + "i) "+n*Math.log(n)); //g) n! h) 7 log log n i)n log n
    }
 
    public static double Factoral(double n){
        int i,fact=1;      
        for(i=1;i<=n;i++){    
            fact=fact*i;    
        }
        return fact;
    }
}

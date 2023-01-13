/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signs;

import java.util.*;

/**
 *
 * @author Tuomo
 */
public class Signs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I compare signs.");
        System.out.println("PEnter the first integer:");
        int int1=scan.nextInt();
        System.out.println("Enter the second integer:");
        int int2=scan.nextInt();
        Vertailu(int1, int2);
    }

    public static void Vertailu(int int1, int int2) {
        if ((int1<0 && int2<0)||(int1>-1 && int2>-1)){
            System.out.println("The signs are the same.");
        }
        else{
            System.out.println("The signs are different.");
        }

    }


}
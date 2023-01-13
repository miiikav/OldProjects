/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpart;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class ShortestPart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I find the length of the shortest substring.");
        System.out.println("Please, enter a string:");
        String lause = scan.nextLine();
        int pituus=FindShortest(lause);
        System.out.println("The length is "+pituus+".");
    }

    public static int FindShortest(String lause) {
        String[]osat = lause.split("[ ]");
        int index=0;
        int min=Integer.MAX_VALUE;
        while(index<osat.length){
            if(osat[index].length()<min){
                min=osat[index].length();
            }
            index++;
        }
        return min;
    }
    
}

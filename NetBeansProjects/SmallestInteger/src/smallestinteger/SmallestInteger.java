/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallestinteger;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class SmallestInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I determine the smallest integer.");
        System.out.println("Please, enter the number of integers:");
        int määrä=scan.nextInt();
        if (määrä<=0){
            System.out.println("Error!");
        }
        else{
            int kertaa=0;
            int pienin=Integer.MAX_VALUE;
            while(määrä>kertaa){
                System.out.println("Please, enter an integer:");
                int luku=scan.nextInt();
                if(luku<pienin){
                    pienin=luku;
                }
                kertaa++;
            }
            System.out.println("The smallest integer is "+pienin+".");
        }
    }
    
}

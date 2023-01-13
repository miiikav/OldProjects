/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phscale;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class PHScale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I classify solutions using the pH scale.");
        System.out.println("Enter pH value:");
        double pH=scan.nextDouble();
        if (pH<7){
            System.out.println("Solution is acid.");
        }
        else if (pH==7){
            System.out.println("Solution is neutral.");
        }
        else if (pH>7){
            System.out.println("Solution is alkaline.");
        }
    }
    
}

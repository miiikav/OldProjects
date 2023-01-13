/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xnor;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class XNOR {

    private static boolean kokototuus;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am XNOR.");
        System.out.println("Please, enter the first truth value:");
        String syote1 = scan.next();
        System.out.println("Please, enter the second truth value:");
        String syote2 = scan.next();
        Totuus(syote1, syote2);
        if (kokototuus==false){
            System.out.println("The result is false.");
        }
        else if (kokototuus==true){
            System.out.println("The result is true.");
        }
        
    }

    public static void Totuus(String syote1, String syote2) {
        boolean totuus1 = Boolean.parseBoolean(syote1);
        boolean totuus2 = Boolean.parseBoolean(syote2);
        if(totuus1==false && totuus2==false){
            kokototuus=true;
        }
        else if(totuus1==false && totuus2==true){
            kokototuus=false;
        }
        else if(totuus1==true && totuus2==false){
            kokototuus=false;
        }
        else if(totuus1==true && totuus2==true){
            kokototuus=true;
        }
    }
    
}

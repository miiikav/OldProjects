/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloyou;
import java.util.*;

/**
 *
 * @author Tuomo
 */
public class HelloYou {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I shall say hello to you.");
        System.out.println("Please, enter your name:");
        String nimi = scan.nextLine();
        Terve(nimi);
    }

    public static void Terve(String nimi) {
        System.out.println("Hello "+nimi+"!");
    }
    
}

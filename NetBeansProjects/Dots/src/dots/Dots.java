/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Dots {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String merkit = "";
        System.out.println("Hello! I print out an acronym.");
        System.out.println("Please, enter a character:");
        String merkki=scan.next();
        merkit=merkit+merkki;
        while (!merkki.equals(".")){
            System.out.println("Please, enter a character:");
            merkki=scan.next();
            if(!merkki.equals(".")){
                merkit=merkit+"."+merkki;
            }
            else{
                merkit=merkit+merkki;
            }
        }
        System.out.println(merkit);
    }
    
}

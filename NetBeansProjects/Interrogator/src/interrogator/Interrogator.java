/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interrogator;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Interrogator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I ask a mandatory question.");
        System.out.println("Please, enter the question:");
        String lause=scan.nextLine();
        System.out.println("Please, enter the first answer:");
        String eka=scan.next();
        System.out.println("Please, enter the second answer:");
        String toka=scan.next();
        String oikein="";
        while(!oikein.equals(eka) && !oikein.equals(toka)){
            System.out.println(lause);
            oikein=scan.next();
            if(!oikein.equals(eka) && !oikein.equals(toka)){
                System.out.println("Error!");
            }
        }
        System.out.println("See you soon.");
    }
    
}

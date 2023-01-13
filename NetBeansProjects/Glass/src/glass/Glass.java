/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glass;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Glass {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I tell about glasses.");
        System.out.println("Are you an (o)ptimist or a (p)essimist?");
        String vastaus=scan.next();
        if (vastaus.equals("o")) {
            System.out.println("The glass half full.");
        }
        else{
            System.out.println("The glass half empty.");
        }
    }
}

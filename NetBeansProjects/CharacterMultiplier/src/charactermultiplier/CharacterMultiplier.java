/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactermultiplier;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class CharacterMultiplier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I multiply characters.");
        System.out.println("Please, enter a string:");
        String lause=scan.next();
        System.out.println("Please, enter location:");
        int kohta=scan.nextInt();
        System.out.println("Please, enter multiplier:");
        int toisto=scan.nextInt();
        int määrä=0;
        if(kohta>lause.length() || lause.length()<=0 || toisto<1){
            System.out.println("Error!");
        }
        else {
            while (kohta+1>määrä){
                System.out.print(lause.charAt(määrä));
                määrä++;
            }
            while (toisto>0){
                System.out.print(lause.charAt(kohta));
                toisto--;
            }
            while (lause.length()>määrä){
                System.out.print(lause.charAt(määrä));
                määrä++;
            }
            System.out.println();
        }
    }
    
}

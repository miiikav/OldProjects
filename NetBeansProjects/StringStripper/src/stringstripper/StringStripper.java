/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringstripper;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class StringStripper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I strip characters from a string.");
        System.out.println("Please, enter the string:");
        String lause=scan.nextLine();
        System.out.println("Please, enter the number of characters:");
        int luku=scan.nextInt();
        int määrä=0;
        int pituus=lause.length()-luku;
        if(luku>lause.length() || lause.length()<=0 || luku<=0 || luku*2>=lause.length()){
            System.out.println("Error!");
        }
        else {
            while (pituus-luku>määrä){
                System.out.print(lause.charAt(määrä+luku));
                määrä++;
            }
            System.out.println();
        }
        
    }
    
}

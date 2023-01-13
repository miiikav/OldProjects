/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactercomparator;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class CharacterComparator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I compare two characters of a string.");
        System.out.println("Please, enter string:");
        String sana = scan.next();
        //virheiden välttämiseksi
        int pituus = sana.length();
        System.out.println("Please, enter the first position:");
        int num1 = scan.nextInt();
        System.out.println("Please, enter the second position:");
        int num2 = scan.nextInt();
        //estää liian isot numerot
         if(num1+1>sana.length() || num2+1>sana.length()){
            System.out.println("Error!");
        }
        else{
            char kir1 = sana.charAt(num1);
            char kir2 = sana.charAt(num2);
            if(kir1==kir2){
                System.out.println("'"+kir1+"' is equal to '"+kir2+"'.");
            }
            else if(kir1!=kir2){
                System.out.println("'"+kir1+"' is different from '"+kir2+"'.");
            }
            else if(kir1>pituus || kir2>pituus){
                System.out.println("Error!");
            }
        }
    }
    
}

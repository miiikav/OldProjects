/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawteeth1;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class SawTeeth1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String saw="";
        System.out.println("Hello! I print saw teeth.");
        System.out.println("Please, enter the number of characters:");
        int luku = scan.nextInt();
        int määrä = 0;
        if(luku==0){
        System.out.println("Error!");
        }
        if(luku%2==0 && luku!=0){
            
        }

        while (määrä<luku){
            if(luku%2==0){
                saw=saw+"\\";
            }
            if(luku%2!=0){
                saw=saw+"/";
            }
            määrä++;
        }

        if(luku%2!=0){
        System.out.println(saw);
        }
        if(luku%2==0){
        System.out.println("/"+saw+"\\");
        }

    }
    
}

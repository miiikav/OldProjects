/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bizzbuzz;
import java.util.*;

/**
 *
 * @author Tuomo
 */
public class BizzBuzz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peli=1;
        String vastaus="";
        System.out.println("Hello! This is a BizzBuzz simulation.");
        System.out.println("Please, enter the number of turns:");
        int turn=scan.nextInt();
        while(turn!=0){
            if(peli%3==0 && peli%5==0){
                vastaus=vastaus+", bizz buzz";
            }
            else if(peli%3==0){
                vastaus=vastaus+", bizz";
            }
            else if(peli%5==0){
                vastaus=vastaus+", buzz";
            }

            else if (peli==1){
                 vastaus=vastaus+peli;
            }
            else{
                 vastaus=vastaus+", "+peli;
            }

            peli++;
            turn--;
        }
        System.out.println(vastaus+".");
    }
    
}

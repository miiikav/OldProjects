/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasons;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Seasons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I can tell you your favourite season.");
        System.out.println("Which do you like most: 1) winter, 2) spring, 3) summer, 4) autumn?");
        int season=scan.nextInt();
        if (season==1){
            System.out.println("Your favourite season of the year is winter.");
        }
        else if (season==2){
            System.out.println("Your favourite season of the year is spring.");
        }
        else if (season==3){
            System.out.println("Your favourite season of the year is summer.");
        }
        else if (season==4){
            System.out.println("Your favourite season of the year is autumn.");
        }
        else{
            System.out.println("Your favourite season of the year is unknown.");
        }
    }
    
}

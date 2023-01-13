/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasons_switch;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Seasons_switch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I can tell you your favourite season.");
        System.out.println("Which do you like most: 1) winter, 2) spring, 3) summer, 4) autumn?");
        int season=scan.nextInt();
            switch (season) {
                case 1:
                    System.out.println("Your favourite season of the year is winter.");
                    break;
                case 2:
                    System.out.println("Your favourite season of the year is spring.");
                    break;
                case 3:
                    System.out.println("Your favourite season of the year is summer.");
                    break;
                case 4:
                    System.out.println("Your favourite season of the year is autumn.");
                    break;
                default:
                    System.out.println("Your favourite season of the year is unknown.");
                    break;
            }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grader;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Grader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am a grader.");
        System.out.println("Please, enter exam points:");
        int points=scan.nextInt();
        System.out.println("Please, enter bonus points:");
        int bonus=scan.nextInt();
        if (points<12 || bonus>3){
            System.out.println("I cannot give a grade.");
        }
        else if (points+bonus<=14){
            System.out.println("Your grade is 1.");
        }
        else if (points+bonus<=17){
            System.out.println("Your grade is 2.");
        }
        else if (points+bonus<=20){
            System.out.println("Your grade is 3.");
        }
        else if (points+bonus<=22){
            System.out.println("Your grade is 4.");
        }
        else if (points+bonus<=24){
            System.out.println("Your grade is 5.");
        }
    }
    
}

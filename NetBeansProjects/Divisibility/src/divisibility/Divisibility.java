/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisibility;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Divisibility {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I determine whether x is divisible by y");
        System.out.println("Please, enter x:");
        int x=scan.nextInt();
        System.out.println("Please, enter y:");
        int y=scan.nextInt();
        if (y==0){
            System.out.println("Error");
        }
        else if (x==0){
            System.out.println(x+" is not divisible by "+y);
        }
        else if (x%y!=0){
            System.out.println(x+" is not divisible by "+y);
        }
        else if (x%y==0){
            System.out.println(x+" is divisible by "+y);
        }
        else{
            System.out.println("Error");
        }
    }
    
}

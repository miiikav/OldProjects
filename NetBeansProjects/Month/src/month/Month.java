/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package month;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Month {

    private static String month;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I verbalise your input.");
        System.out.println("Please, enter a number:");
        int luku=scan.nextInt();
        Month(luku);
        System.out.println("It is "+month+".");

    }

    public static void Month(int luku) {
        String January="January";
        String February="February";
        String March="March";
        String April="April";
        String May="May";
        String June="June";
        String July="July";
        String August="August";
        String September="September";
        String October="October";
        String November="November";
        String December="December";
        String[]array={January, February, March, April, May, June, July, August, September, October, November, December};
        month=array[luku-1];
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcomparator;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class StringComparator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I compare strings.");
        System.out.println("Please, enter the first string:");
        String first=scan.next();
        System.out.println("Please, enter the second string:");
        String second=scan.next();
        while(!second.equals("stop") || !first.equals("stop")){
            if(first.equals(second)){
                System.out.println("\""+first+"\""+" is equal to "+"\""+second+"\"");
                System.out.println("Please, enter the first string:");
                first=scan.next();
                System.out.println("Please, enter the second string:");
                second=scan.next();
            }
            else if(!first.equals(second)){
                System.out.println("\""+first+"\""+" is different from "+"\""+second+"\"");
                System.out.println("Please, enter the first string:");
                first=scan.next();
                System.out.println("Please, enter the second string:");
                second=scan.next();
            }
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringlengthcomparator;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class StringLengthComparator {

    private static int comparator;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I compare the lengths of two strings.");
        System.out.println("Please, enter the first string:");
        String first=scan.nextLine();
        System.out.println("Please, enter the second string:");
        String second=scan.nextLine();
        Vertailu(first, second);
        switch (comparator) {
            case -1:
                System.out.println("\""+first+"\" is shorter than \""+second+"\".");
                break;
            case 0:
                System.out.println("\""+first+"\" is as long as \""+second+"\".");
                break;
            case 1:
                System.out.println("\""+first+"\" is longer than \""+second+"\".");
                break;
            default:
                break;
        }
    }

    public static void Vertailu(String first, String second) {
        int jono1 = first.length();
        int jono2 = second.length();
        if (jono1<jono2){
            comparator=-1;
        }
        else if(jono1==jono2){
            comparator=0;
        }
        else if(jono1>jono2){
            comparator=1;
        }
    }
    
}

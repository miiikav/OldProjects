/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pairs2;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Pairs2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String kaari1="(";
        String kaari2= ")";
        String aalto1="{";
        String aalto2="}";
        String haka1="[";
        String haka2="]";
        String kulma1="<";
        String kulma2=">";
        System.out.println("Hello! I find pairs.");
        System.out.println("Enter the first character:");
        String first = scan.next();
        System.out.println("Enter the second character:");
        String second = scan.next();
        if(first.equals(kaari1) && second.equals(kaari2)||first.equals(aalto1) && second.equals(aalto2)||first.equals(haka1) && second.equals(haka2)||first.equals(kulma1) && second.equals(kulma2)){
            System.out.println("Characters "+"'"+first+"'"+" and "+"'"+second+"'"+" are a pair.");
        }
        else{
            System.out.println("Characters "+"'"+first+"'"+" and "+"'"+second+"'"+" are not a pair.");
        }
    }
    
}
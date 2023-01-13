/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string2array;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class String2Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I convert a string to an array.");
        System.out.println("Please, enter the string:");
        String sana= scan.next();
        //String sana=In.readString();
        char[]paluuarvo = Muuntaja(sana);
        Print(paluuarvo);
        
    }

    public static char[] Muuntaja(String sana) {
        char[] array = new char[sana.length()];
        int index=0;
        while(index<sana.length()){
            char value=sana.charAt(index);
            array[index]=value;
            index++;
        }
        return array;
    }
        
    public static void Print(char[] array) {
        if(array!=null){
            int index=0;
            System.out.print("{ ");
            while (index<array.length){
                System.out.print(array[index]+" ");
                index++;
            }
            System.out.print("}");
            System.out.println();
        }
    }
}

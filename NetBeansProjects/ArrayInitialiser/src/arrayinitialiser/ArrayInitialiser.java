/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayinitialiser;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class ArrayInitialiser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am an array initialiser.");
        System.out.println("Please, enter size:");
        int size = scan.nextInt();
        if(size<1){
            System.out.println("Error!");
        }
        else{
            System.out.println("Please, enter value:");
            int value = scan.nextInt();
            int[] array = new int[size];
            int index=0;
            while (index<size){
                array[index]=value;
                index++;
            }
            index=0;
            System.out.print("{ ");
            while (index<size){
                System.out.print(array[index]+" ");
                index++;
            }
            System.out.print("}");
            System.out.println();
        }
        
    }
    
}

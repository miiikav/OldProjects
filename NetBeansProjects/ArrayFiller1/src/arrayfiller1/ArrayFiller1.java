/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayfiller1;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class ArrayFiller1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am an array filler.");
        System.out.println("Please, enter size:");
        int size = scan.nextInt();
        if(size<1){
            System.out.println("Error!");
        }
        else{
            int index=1;
            int index2=0;
            char[] array = new char[size];
            while(index<size+1){
                System.out.println("Please, enter value "+index+":");
                char value = scan.next().charAt(0);
                array[index2]=value;
                index++;
                index2++;
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

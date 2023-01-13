/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayfiller3;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class ArrayFiller3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am an array filler.");
        System.out.println("Please, enter size:");
        int size = scan.nextInt();
        if(size<0){
            System.out.println("Error!");
        }
        else{
            char[] array = new char[size];
            boolean test = Filler(array);
            if(test==false){
                System.out.println("Error!");
            }
            else if (test==true){
                Print(array);
            }
        }
    }
    public static boolean Filler(char[] array) {
        Scanner scan = new Scanner(System.in);
        if(array==null || array.length<1){
            return false;
        }
        else{
            int index=1;
            int index2=0;

            while(index<array.length+1){
                System.out.println("Please, enter value "+index+":");
                char value = scan.next().charAt(0);
                array[index2]=value;
                index++;
                index2++;
            }
            return true;
        }
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

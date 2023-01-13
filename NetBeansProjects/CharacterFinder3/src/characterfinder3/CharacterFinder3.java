/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterfinder3;

import java.util.Scanner;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;
/**
 *
 * @author Tuomo
 */
public class CharacterFinder3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I try to find a character.");
        System.out.println("Please, enter array size:");
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
                 BinarySearch(array);
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
                System.out.println("Please, enter element value "+index+":");
                char value = scan.next().charAt(0);
                array[index2]=value;
                index++;
                index2++;
            }
            return true;
        }
    }


    public static void  BinarySearch(char[] array) {
        if(array!=null){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please, enter a character:");
            char kirjain = scan.next().charAt(0);
            sort(array);
            int vertailu = binarySearch( array, kirjain);
            if(vertailu>0){
                System.out.println("Character '"+kirjain+"' was found.");
                System.out.println(vertailu);
            }
            else{
                System.out.println("Character '"+kirjain+"' was not found.");
                System.out.println(vertailu);
            }
        }
    }
}

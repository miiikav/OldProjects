/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characterfinder2;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class CharacterFinder2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //NetBeansin takia käytin scanner luokkaa ohjelman teossa.
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I try to find a character.");
        System.out.println("Please, enter array size:");
        int size = scan.nextInt();
        if(size<1){
            System.out.println("Error!");
        }
        else{
            

            int index=1;
            int index2=0;
            char[] array = new char[size];
            while(index<size+1){
                System.out.println("Please, enter element value "+index+":");
                char value = scan.next().charAt(0);
                array[index2]=value;
                index++;
                index2++;
            }
            System.out.println("Please, enter a character:");
            char kirjain = scan.next().charAt(0);
            Print(array, kirjain);
            if(löytyi==true){
                System.out.println("Character "+"'"+kirjain+"'"+" was found.");
            }
            else if(löytyi==false){
                System.out.println("Character "+"'"+kirjain+"'"+" was not found.");
            }
        }
    }
        private static boolean löytyi=false;
        public static void Print(char[] array, char kirjain) {
        if(array!=null){
            int index=0;
            while (index<array.length){
                if(array[index]==kirjain){
                    löytyi=true;
                }
                index++;
            }
        }
    }
}

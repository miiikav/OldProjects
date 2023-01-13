/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementswapper;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class ElementSwapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I swap element values.");
        System.out.println("Please, enter array size:");
        int size = scan.nextInt();
        if(size<0){
            System.out.println("Error!");
        }
        else{
            int[] array = new int[size];
            boolean test = Filler(array);
            if(test==false){
                System.out.println("Error!");
            }
            else if (test==true){
                Print(array);
                System.out.println("Enter the first index value:");
                int first=scan.nextInt();
                System.out.println("Enter the second index value:");
                int second=scan.nextInt();
                boolean test2=Swapper(array,first,second);
                if(test2==false){
                    System.out.println("The element values were not swapped.");
                    Print(array);
                }
                else if (test2==true){
                    System.out.println("The element values were swapped.");
                    Print(array);
                }
            }
        }
    }
    public static boolean Filler(int[] array) {
        Scanner scan = new Scanner(System.in);
        if(array==null || array.length<1){
            return false;
        }
        else{
            int index=1;
            int index2=0;

            while(index<array.length+1){
                System.out.println("Please, enter element value "+index+":");
                int value = scan.nextInt();
                array[index2]=value;
                index++;
                index2++;
            }
            return true;
        }
    }
    public static void Print(int[] array) {
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

    private static boolean Swapper(int[] array, int first, int second) {
        if((first<0 || first>array.length-1) ||(second<0 || second>array.length-1)){
            return false;
        }
        else{
            int temp = array[first];
            array[first] = array[second];
            array[second] = temp;
            return true;
        }
    }
}

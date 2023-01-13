/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringsaver;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuomo
 */
public class StringSaver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am an array copier.");
        System.out.println("Please, enter the number of rows:");
        int rows=scan.nextInt();
        System.out.println("Please, enter the number of columns:");
        int columns=scan.nextInt();   
        char[][] array=Filler(rows,columns);
        if(array==null){
            System.out.println("Error!");
        }
        else{
            boolean test=Writer(array);
            if(test=false){
                System.out.println("Error!");
            }
            else if(test=true){
                System.out.println("Array saved.");
            }
        }
    }
    public static char[][] Filler(int rows,int columns) {
        if(rows<=0 || columns<=0){
            return null;
        }
        else{
            Scanner scan = new Scanner(System.in);
            char[][] array = new char[rows][columns];
            int index=1;
            int index2=0;
            int index3=0;
            while(index<array.length+1){
                System.out.println("Please, enter row "+index+":");
                    String value = scan.next();
                    char[] temp=new char [columns];
                    temp=value.toCharArray();
                    while(index3<array[0].length){
                        array[index2][index3]=temp[index3];
                        index3++;
                    }
                index++;
                index2++;
                index3=0;
            }
            return array;
        }

    }
    
    public static void Print(char[][] array) {
        if(array!=null){
            int index=0;
            int index2=0;
            while (index<array.length){
                while (index2<array[0].length){     
                    System.out.print(array[index][index2]);
                    index2++;
                }
                System.out.println();
                index2=0;
                index++;
            }
        }
    }

    public static boolean Writer(char[][] array) {
        if(array!=null){
            FileOutputStream output = null;
            try {
                String txtname = "lines.txt";
                File txtfile= new File(txtname);
                output = new FileOutputStream(txtfile);
                PrintWriter writer = new PrintWriter(output, true);
                int index=0;
                int index2=0;
                while (index<array.length){
                    while (index2<array[0].length){     
                        writer.print(array[index][index2]);
                        index2++;
                    }
                    writer.println();
                    index2=0;
                    index++;
                }
                writer.close();
                return true;
            } catch (FileNotFoundException ex) {
                return false;
            } finally {
                try {
                    output.close();
                } catch (IOException ex) {
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }
}

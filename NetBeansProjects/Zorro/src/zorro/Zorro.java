/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zorro;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Zorro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hola! I am Zorro.");
        System.out.println("Please, enter mark:");
        String z = scan.next();
        System.out.println("Please, enter size:");
        int size = scan.nextInt();
        if(size<3){
        System.out.println("No comprendo.");
        }
        else{
            int size2 = size;
            int line=0;
            while(size>line){
                System.out.print(z);
                line++;
                
            }
            size2=size2-2;
            line=line*0;
            System.out.print("\n");
            while(size2>line || size2!=0){
                System.out.print(" ");
                line++;
                if(size2==line){
                    System.out.print(z+"\n");
                    size2--;
                    line=line*0;
                }
            }
            while(size>line){
                System.out.print(z);
                line++;
                if(size==line){
                    System.out.print("\n");
                }
            }
        }
    }
    
}
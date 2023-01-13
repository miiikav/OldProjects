/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii.kala;
import java.util.*;
import java.util.Random; 
/**
 *
 * @author Tuomo
 */
public class ASCIIKala {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random generator = new Random(); 
        int Random;
        String kupla="";
        System.out.println("Kunka monta kuplaa haluat?");
        int luku = scan.nextInt();
        int määrä = 0;
        while (määrä<luku){
        Random = generator.nextInt(3)+1; 
        switch (Random) {
            case 1:
                 kupla=kupla+"o";
                break;
            case 2:
                kupla=kupla+"O";
                break; 
            case 3:
                kupla=kupla+"0";
                break;
            default:
                break;
        }
        määrä=määrä+1;
        }
      System.out.println(kupla+">}}}`>");
    }
}

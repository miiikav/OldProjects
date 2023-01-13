/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yhtäsuuri;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Yhtäsuuri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Anna luku:");
        int vluku=scan.nextInt();
        int määrä=0;
        int oikein=0;
        System.out.println("Kuinka monta kierrosta?");
        int kierros=scan.nextInt();
        while(määrä<kierros){
        System.out.println("Anna luku:");
        int uusiluku=scan.nextInt();
        if(uusiluku==vluku){
            oikein++;
            }
        määrä++;
        }
        System.out.println(oikein+" oikein");
    }
    
}

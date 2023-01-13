/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yksinkertainen.laskin;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class YksinkertainenLaskin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Olen yksinkertainen laskin!");
        System.out.println("Anna 1. luku");
        int ekaluku=scan.nextInt();
        System.out.println("Anna 2. luku");
        int tokaluku=scan.nextInt();
        int plus=ekaluku+tokaluku;
        int miinus=ekaluku-tokaluku;
        double jako=(1.0*ekaluku/tokaluku);
        int kerto=ekaluku*tokaluku;
        int prosentti=ekaluku%tokaluku;
        System.out.println(ekaluku+" + "+tokaluku+" = "+plus);
        System.out.println(ekaluku+" - "+tokaluku+" = "+miinus);
        System.out.println(ekaluku+" / "+tokaluku+" = "+jako);
        System.out.println(ekaluku+" * "+tokaluku+" = "+kerto);
        System.out.println(ekaluku+" % "+tokaluku+" = "+prosentti);
    }
    
}
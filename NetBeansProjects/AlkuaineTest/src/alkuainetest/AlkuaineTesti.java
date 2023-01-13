/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkuainetest;

/**
 *
 * @author Tuomo
 */
public class AlkuaineTesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello! I test chemical elements.");
        System.out.println("Please, enter the symbol of the element:");
        String type=In.readString();
        System.out.println("Please, enter the atomic number of the element:");
        int num=In.readInt();
        Alkuaine testi = new Alkuaine();
        // Asettavien metodien kutsut.
        testi.merkki(type);
        testi.numero(num);
        // Lukevien metodien kutsut.
        int nnum=testi.numero();
        String ntype=testi.merkki();
        System.out.println("State is "+ntype+" and "+nnum+".");
    }
    
}

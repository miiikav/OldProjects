/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pullatesti;

import static java.lang.Boolean.parseBoolean;

/**
 *
 * @author Tuomo
 */
public class PullaTesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        System.out.println("Hello! I test buns.");
        System.out.println("What is the weight of the bun?");
        double num=In.readDouble();
        System.out.println("Is the bun lactose-free?");
        String type=In.readString();
        boolean type2=Boolean.parseBoolean(type);
        Pulla testi = new Pulla();
        // Asettavien metodien kutsut.
        testi.paino(num);
        testi.laktoositon(type2);
        // Lukevien metodien kutsut.
        double nnum=testi.paino();
        boolean ntype=testi.laktoositon();
        System.out.println("State is "+nnum+" and "+ntype+".");
    }
    
}

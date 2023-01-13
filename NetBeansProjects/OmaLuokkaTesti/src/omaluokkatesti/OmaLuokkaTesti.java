/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omaluokkatesti;

/**
 *
 * @author Tuomo
 */
public class OmaLuokkaTesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello! I test random stuff.");
        System.out.println("Please, enter a country to play:");
        String tag=In.readString();
        System.out.println("Please, enter the amount of gold:");
        double cash=In.readDouble();
        System.out.println("Please, enter the amount of manpower:");
        int num=In.readInt();
        //Asetetaan
        OmaLuokka testi = new OmaLuokka();
        testi.country(tag);
        testi.gold(cash);
        testi.manpower(num);
        //Luetaan
        String readtag=testi.country();
        double readcash=testi.gold();
        int readnum=testi.manpower();
        System.out.println("Country is "+readtag+".");
        System.out.println("You have "+readcash+" in gold.");
        System.out.println("You have "+readnum+" available manpower.");
    }
    
}

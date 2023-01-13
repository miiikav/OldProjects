/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rauta;

/**
 *
 * @author Tuomo
 */
public class Rauta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String englanniksi="iron";
        String tunnus="Fe";
        String lohko="d";
        int järjestysluku=26;
        double elektronegatiivisuus=55.845;
        String tiheys="7.86*10^3";
        String onkoJalometalli ="ei";
        System.out.println("Joitakin tietoja alkuaineesta rauta:");
        System.out.println("- In English: " + englanniksi + ".");
        System.out.println("- Tunnus jaksollisessa järjestelmässä: " + tunnus + ".");
        System.out.println("- Lohko jaksollisessa järjestelmässä: " + lohko + ".");
        System.out.println("- Järjestysluku jaksollisessa järjestelmässä: " + järjestysluku + ".");
        System.out.println("- Elektronegatiivisuus Paulingin asteikolla: " + elektronegatiivisuus + ".") ;
        System.out.println("- Tiheys: " + tiheys + " kg / m^3.");
        System.out.println("- Onko jalometalli: " + onkoJalometalli + ".");
    }
    
}

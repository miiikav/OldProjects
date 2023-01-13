/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oppilaitostesti;

/**
 *
 * @author Tuomo
 */
public class OppilaitosTesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello! I test educational institutions.");
        System.out.println("Please, enter the number of students:");
        int num=In.readInt();
        System.out.println("Please, enter the type of the institution:");
        int type=In.readInt();
        Oppilaitos testi = new Oppilaitos();
        // Asettavien metodien kutsut.
        testi.opiskelijoita(num);
        testi.aste(type);
        // Lukevien metodien kutsut.
        int nnum=testi.opiskelijoita();
        int ntype=testi.aste();
        System.out.println("State is "+nnum+" and "+ntype+".");
    }
    
}

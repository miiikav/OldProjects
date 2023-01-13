/*
 * Ohjelma lukee käyttäjän antaman tekstitiedoston silällön ja tulostaa sen näytölle
 */
package fileprinter;
import java.util.*;
import java.io.*;

/**
 *
 * @author tuomo
 */
public class FilePrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I print a file to the screen.");
        System.out.println("Please, enter file name:");
        String txt=scan.nextLine();
        //käyttäjän syöte annetaan operaatiolle parametrkisi
        boolean txttest=TxtReader(txt);
        //jos ohjelma ei löydä tiedostoa se tulostaa tämän
        if(txttest==false){
            System.out.println("I could not print.");
        }
    }

    public static boolean TxtReader(String txt) {
        try { 
            File txtfile= new File(txt);
            Scanner lukija = new Scanner(txtfile);
            while(lukija.hasNextLine()) {
                String rivi = lukija.nextLine(); 
                System.out.println(rivi);
            }
        } catch (FileNotFoundException ex) {
            //tiedostoa ei löytynyt palautetaan false
            return false;
        }
        return true;
    }
    
}
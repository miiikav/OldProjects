/*
Ohjelma, joka palauttaa lukua vastaavan merkin. 
 */
package judge;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class Judge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //NetBeansin takia käytin scanner luokkaa ohjelman teossa.
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am a judge of character.");
        System.out.println("Please, enter an integer:");
        int num = scan.nextInt();
        //int num = In.readInt();
        //Tarkistetaan ennen taulukosta lukemista, että parametri on oikeellinen. 
        if(num<0||num>15){
            System.out.println("I cannot judge "+num+".");
        }
        else{
            char paluuarvo = Select(num);
            System.out.println("I judge "+num+" as '"+paluuarvo+"'.");
        }
        
        
            }

    public static char Select(int num) {
        //sijoitetaan merkit yksiulotteiseen taulukkoon.
        char[] merkit = {'#', '@', '&', '$', '%', 'x', '*',
            'o', '|', '!', ';', ':', '\'', ',', '.', ' ' };
        // Valitaan numeroa vastaava merkki ja palautetaan se.
        return merkit[num];
    }
    
}

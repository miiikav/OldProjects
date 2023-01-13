/*
 * 
 * Ohjelma merkin hakemiseen merkkijonosta.
 * 
 */
package characterfinder1;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class CharacterFinder1 {

    /**
     * @param args the command line arguments
     */


    
    public static void main(String[] args) {
        //NetBeansin takia käytin scanner luokkaa ohjelman teossa.
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I try to find a character.");
        System.out.println("Please, enter a string:");
        String sana=scan.next();
        //String sana=In.readString();
        System.out.println("Please, enter a character:");
        char kirjain = scan.next().charAt(0);
        //char kirjain = In.readChar();
        //kutsutaan operaattoria ja annetaan sille tiedot sanasta ja kirjaimesta.
        Etsijä(sana, kirjain);
        //palataan main-operaatioon ja tarkistetaan booleanin tila.
        if(löytyi==true){
            System.out.println("Character "+"'"+kirjain+"'"+" was found.");
        }
        else if(löytyi==false){
            System.out.println("Character "+"'"+kirjain+"'"+" was not found.");
        }
    }
    //boolean operaattori, joka toimii molemmissa operaatioissa.
    private static boolean löytyi=false;
    
    public static void Etsijä(String sana, char kirjain) {

        int index=0;
        while(index<sana.length()){
            if(sana.charAt(index)==(kirjain)){
                löytyi=true;
            }
            index++;
        }
    }
    
}

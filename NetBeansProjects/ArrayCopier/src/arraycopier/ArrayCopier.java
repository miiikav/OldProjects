/*
Ohjelma kopioi annetun taulukon rivit käänteisessä järjestyksessä uuteen taulukkoon.
 */
package arraycopier;

import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class ArrayCopier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am an array copier.");
        System.out.println("Please, enter the number of rows:");
        int rows=scan.nextInt();
        System.out.println("Please, enter the number of columns:");
        int columns=scan.nextInt();
        char[][] array=Filler(rows,columns);

        if(array==null){
            System.out.println("Error!");
        }
        else{
            //tulostetaan muuttumaton taulukko ennen kääntämisoperaatiota.
            tulosta(array);
            ArrayMirror(array);
            tulosta(array);
        }
    }
        
    public static char[][] Filler(int rows,int columns) {
        //tarkistetaan, että taukukko ei ole tyhjä.
        if(rows<=0 || columns<=0){
            return null;
        }
        else{
            Scanner scan = new Scanner(System.in);
            char[][] array = new char[rows][columns];
            int index=1;
            int index2=0;
            int index3=0;
            while(index<array.length+1){
                System.out.println("Please, enter row "+index+":");
                    String value = scan.next();
                    //temp taulukko tiedon siirtämistä tai väiliaikaista tallentamista varten.
                    char[] temp=new char [columns];
                    //Muutetaan String char[] tyypiksi ja siiretään tieto väliaikaiseen taulukkon.
                    temp=value.toCharArray();
                    while(index3<array[0].length){
                        array[index2][index3]=temp[index3];
                        index3++;
                    }
                index++;
                index2++;
                index3=0;
            }
            return array;
        }

    }
    private static char[][] ArrayMirror(char[][] array) {
        //tarkistetaan onko taulukolle varattu muistia.
        if(array != null){
            //for luuppi, joka pysäytetään taulukon puolessa välissä.
            for(int i = 0; i < (array.length/2); i++) {
                    //temp taulukko tiedon siirtämistä tai väiliaikaista tallentamista varten.
                    char[] temp = array[i];
                    array[i] = array[array.length - i - 1];
                    array[array.length - i - 1] = temp;
            }
            //palautetaan muutettu taulukko.
            return array;
        }
        //ei miustia, palautetaan null.
        else{
            return null;
        }
    }
    public static void tulosta(char[][] t) {
      // Tulostetaan vain, jos taulukolle on varattu muistia.
      if (t != null) {
         // Rivien ja sarakkeiden lukumäärät.
         int rivlkm = t.length;
         int sarlkm = t[0].length;

         // Tulostetaan rivit.
         for (int rivi = 0; rivi < rivlkm; rivi++) {
            // Tulostetaan rivi.
            for (int sarake = 0; sarake < sarlkm; sarake++)
               System.out.print(t[rivi][sarake]);
            // Rivin lopussa vaihdetaan riviä.
            System.out.println();
         }
      }
   }


}

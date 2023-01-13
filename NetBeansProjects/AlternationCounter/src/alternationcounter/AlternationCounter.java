/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alternationcounter;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class AlternationCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I count character alternations.");
        System.out.println("Please, enter a string:");
        String lause=scan.next();
        int määrä=0;
        int laskin=0;
        while (lause.length()>määrä){
            if (määrä==0){
            }
            else if (lause.charAt(määrä)!=lause.charAt(määrä-1)){
                laskin++;
            }
        määrä++;
        }
        System.out.println("There were "+laskin+" alternations.");
    }
    
}

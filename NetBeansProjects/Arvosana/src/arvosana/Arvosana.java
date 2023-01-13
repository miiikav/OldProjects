/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arvosana;

/**
 *
 * @author Oppilas
 */
public class Arvosana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int Pisteet =60;
    if (Pisteet<30) System.out.println("Hylätty");
    else if (Pisteet<40) System.out.println("Välttävä");
    else if (Pisteet<50) System.out.println("Hyvä");
    else if (Pisteet<60) System.out.println("Erinomainen");
    else if (Pisteet>59) System.out.println("Nyt kyllä huijaat!!!!");
    }
    
}

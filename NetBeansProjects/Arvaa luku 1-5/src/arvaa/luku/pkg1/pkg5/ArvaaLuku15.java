/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arvaa.luku.pkg1.pkg5;
import at3.apu.Lukija;

/**
 *
 * @author Oppilas
 */
public class ArvaaLuku15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int luku = Lukija.lueInt("Arvaa kokonaisluku väliltä 1-5");
    int luku2=(int)(1+ Math.random()*5);
    if(luku2==luku){
        System.out.println("Minunkin lukuni oli "+luku2+". Onnea!");
    }
    else{
        System.out.println("minun luku oli "+luku2+". Huti!");
    }
    }
    }

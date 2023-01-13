/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package noppa;

/**
 *
 * @author Oppilas
 */
public class Noppa {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        double noppa = Math.random();
        if(noppa < 1.0/6.0){
            System.out.println("Nopalla tuli ykkönen");
        }
        else if(noppa < 2.0/6.0){
            System.out.println("Nopalla tuli kakkonen");
        }
        else if(noppa < 3.0/6.0){
            System.out.println("Nopalla tuli kolmonen");
        }
        else if(noppa < 4.0/6.0){
            System.out.println("Nopalla tuli nelonen");
        }     
        else if(noppa < 5.0/6.0){
            System.out.println("Nopalla tuli vitonen");
        }
        else{
            System.out.println("Nopalla tuli kutonen");
        } 
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kertoma;

/**
 *
 * @author Oppilas
 */
public class Kertoma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int kertoma =1;
        for ( int i = 1 ; i<=50; i=i*i+1 ) {
           kertoma=kertoma*i;
    System.out.println(kertoma);
    }
    }
    
}

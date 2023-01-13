/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tira18_01;

/**
 *
 * @author tuomo
 */
        
public class ArrayMaxProgram { // testaa maksimialkion taulukosta etsivän algoritmin 
            
    static int arrayMax(int[ ] A, int n) {     
        //etsii maksimialkion kokonaislukutaulukosta A selaamalla 
        //taulukon alkiot ja pitämällä kirjaa eri vaiheissa suurimmasta 
        //löydetystä 
        int currentMax = A[0]; //suoritetaan kerran 
        for (int i=1; i<n; i++) //asetus suoritetaan kerran, vertailu n kertaa ja 
                                //lisäys n-1 kertaa 
            if (currentMax < A[i]) //suoritetaan n-1 kertaa 
                currentMax = A[i]; //suoritetaan enintään n-1 kertaa 
        return currentMax; //suoritetaan kerran }
    }
    
}

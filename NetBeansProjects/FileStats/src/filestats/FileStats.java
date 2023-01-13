/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filestats;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class FileStats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello! I am a file analyser.");
        if(args.length==1){
            int length[]=FileAnalyzer(args);
            if(length==null){
                System.out.println("I could not analyse.");
            }
            else{         
                System.out.println("- The length of the shortest line is "+length[0]+".");
                System.out.println("- The length of the longest line is "+length[1]+".");
            }
        }
        else{
            System.out.println("I could not analyse.");
        }
    }

    public static int[] FileAnalyzer(String[] args) {
                
        try {
            int[] length = new int[2];
            int shortest=1000;
            int longest=0;
            File txtfile= new File(args[0]);
            Scanner lukija = new Scanner(txtfile);
            while(lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                if(rivi.length()<shortest ||rivi.length()>longest){       
                    if(rivi.length()<shortest){
                        length[0]=rivi.length();
                        shortest=rivi.length();
                    }
                    if(rivi.length()>longest){
                        length[1]=rivi.length();
                        longest=rivi.length();
                    }
                }
            }
            return length;
        } catch (FileNotFoundException ex) {
            //tiedostoa ei löytynyt palautetaan false
            return null;
        }
        
    }
    
}

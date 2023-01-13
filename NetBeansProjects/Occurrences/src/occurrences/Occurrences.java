/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occurrences;

import java.util.*;

/**
 *
 * @author Tuomo
 */
public class Occurrences {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I count character occurrences between strings.");
        System.out.println("Enter the first string:");
        String lause1=scan.nextLine();
        System.out.println("Enter the second string:");
        String lause2=scan.nextLine();
        Vertailija(lause1, lause2);
    }

    public static void Vertailija(String lause1, String lause2) {
        int määrä1=-1;
        int määrä2=-1;
        int määrä3=-1;
        int määrä4=-1;
        int laskin=0;
        String temp = "";
        while (lause2.length()>määrä1){
            if (määrä1==0){
            }
            else{
                while(lause1.length()>määrä2){
                    if(lause2.charAt(määrä1)==lause1.charAt(määrä2)){
                        
                        if(laskin==0){
                            temp=temp+Character.toString(lause1.charAt(määrä2));
                            laskin++;
                        }
                        else{
                            while(temp.length()>määrä3){
                                if(temp.charAt(määrä3)==lause1.charAt(määrä2) && määrä4<0){
                                    temp=temp.substring(0,1);
                                }
                                else if(temp.charAt(määrä3)==lause1.charAt(määrä2)){
                                    määrä3=temp.length()+1;
                                }
                                else if(temp.charAt(määrä3)!=lause1.charAt(määrä2) && määrä4==0){
                                    temp=temp+Character.toString(lause1.charAt(määrä2));
                                    laskin++;
                                }
                                määrä3++;
                            }
                            määrä3=-1;
                            määrä4=-1;
                        }
                    }
                    määrä2++;
                }
            }
            määrä1++;
            määrä2=-1;
        }
        System.out.println("The number of occurrences is "+laskin+"."+temp);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indenter;

/**
 *
 * @author Tuomo
 */
public class Indenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

 
        try {    //...    // Yritetään muuntaa viimeinen komentoriviparametri luvuksi.    
        int syvyys = Integer.parseInt(args[args.length - 1]);
        if(syvyys<=0 || args.length>1){
            System.out.println("Error!");
        }
        else{
            
            int index=0;
            int i=0;
            while(syvyys>index){
            System.out.print(" ");
            index++;
            if(syvyys==index){
                while(i<args.length){
                System.out.println(args[i]);
                i++;
                }
                index=0;
                i=0;
            }
            }
        }
        }
        catch (NumberFormatException e) {
            System.out.println("Error!111");
        }

    }
    
}

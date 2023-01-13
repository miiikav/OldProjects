/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeinspector;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class TimeInspector {

    private static boolean time=true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I inspect a 24-hour time.");
        System.out.println("Please, enter hours:");
        int hour = scan.nextInt();
        System.out.println("Please, enter minutes:");
        int min = scan.nextInt();
        System.out.println("Please, enter seconds:");
        int sec = scan.nextInt();
        Time(sec, min, hour);
        if (time==false){
            System.out.println("invalid");
        }
        else if (time==true){
            System.out.println("valid");
        }

    }

    public static void Time(int sec, int min, int hour) {
        time = !(sec<0 || min<0 || hour<0);

        if(hour==24 && (min>0 || sec>0)){
            time = false;
        }
        else if(sec>59 || min>59 || hour>24){
            time = false;
        }


    }
    
}

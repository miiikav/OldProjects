/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laki2h1;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class StringStats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //NetBeans ei tunnu toimivan In luokan kanssa,
        //jolloin päätin käyttää Scanner luokaa testaamiseen NetBeansissa.
        Scanner scan = new Scanner(System.in);
        Boolean käynnissä = true;
        String uudelleen="";
        System.out.println("Hello! I calculate some string statistics.");
        while (käynnissä){
            System.out.println("Please, enter a string:");
            //Scanner luokka tarvirtsi tätä
            if (uudelleen.equals("y")) {
            scan.nextLine();
            }
            String stats = scan.nextLine();
            //String stats = In.readString();
            String newstats = "";
            int statslength = stats.length();
            int indeksiarvo = 0;
            while (indeksiarvo < statslength) {
                //poistettavat merkit
                char nm = stats.charAt(indeksiarvo);
                if (nm==','||nm=='.'||nm==';'||nm==':'||nm=='?'||
                    nm=='!'||nm=='\''||nm=='\"'||nm=='/'||nm=='('||nm==')') {
                    newstats = newstats + "";
                }
                else {
                    newstats = newstats + nm;
                }
                indeksiarvo = indeksiarvo + 1;
            }
            System.out.println("\""+newstats+"\"");
            indeksiarvo = 0;
            int num=0;
            int sum=0;
            int avg=0;
            int min1=1000;
            int min2=1000;
            int max2=0;
            int max1=0;
            int counter=0;
            int newstatslength = newstats.length();
            while (indeksiarvo < newstatslength) {
                char nm = newstats.charAt(indeksiarvo);
                //välilyöntien kohdalla lasketaan määrä ja summa
                if (nm==' '){
                    num++;
                    sum=sum+counter;
                    counter=0;
                }
                else{
                    counter++;
                    if(indeksiarvo!=newstatslength-1 && newstats.charAt(indeksiarvo+1)==' '){
                        if(counter<min1 || counter>max1){
                            if(counter<min1){
                                min2=min1;
                                min1=counter;
                            }
                            else if(counter>max1){
                                max2=max1;
                                max1=counter;
                            }
                        }
                        else if(counter>max2 && counter!=max1){
                            max2=counter;
                            if(counter<min2){
                                min2=counter;
                            }
                        }
                        else if(counter<min2 && counter!=min1){
                            min2=counter;
                        }
                    }
                }
            indeksiarvo = indeksiarvo + 1;
            }
            
            sum=sum+counter;
            num++;
            if(counter<min1 || counter>max1){
                if(counter<min1){
                    min2=min1;
                    min1=counter;
                }
                else if(counter>max1){
                    max2=max1;
                    max1=counter;
                }
            }
            if((counter>max2 && counter<max1) || (counter<min2 && counter>min1)){
                if ((counter>max2 && counter<max1)){
                    max2=counter;
                }
                if ((counter<min2 && counter>min1)){
                    min2=counter; 
                }
            }
            //joukko sääntöjä joille en löytänyt paikkaa yllä olevassa koodissa
            if (min2==1000 || max2==0){
                if(min2==1000){
                    min2=max2;
                }
                else if (max2==0){
                    max2=min2;
                }
            }
            if(num==2){
                max2=min1;
                min2=max1;
            }
            if(num==1){
                min2=min1;
                max1=min1;
                max2=min1;
            }
            if(min1==max1){
                min2=min1;
                max2=max1;
            }
            if(min1==max1-1){
                max2=min1;
                min2=max1;
            }
            //muutettu doubleksi, jotta pyöristäminen onnistuisi.
            double dnum=num;
            double dsum=sum;
            double davg=Math.round(dsum/dnum);
            avg=(int)davg;
            if(avg==min1+1 && avg==max1-1){
                min2=avg;
                max2=avg;
            }
            System.out.println("- The number of parts is "+num+".");
            System.out.println("- The sum of part lengths is "+sum+".");
            System.out.println("- The average length of parts is "+avg+".");
            System.out.println("- The length of the shortest part is "+min1+".");
            System.out.println("- The length of the second shortest part is "+min2+".");
            System.out.println("- The length of the second longest part is "+max2+".");
            System.out.println("- The length of the longest part is "+max1+".");
            System.out.println("Continue (y/n)?");
            //uudelleen = In.readString();
            uudelleen = scan.next();
            if (uudelleen.equals("y")) {
                stats="";
                käynnissä = true;
            }
            else if (uudelleen.equals("n")) {
                System.out.println("See you soon.");
                käynnissä = false;
            }
            while ((!uudelleen.equals("y") && !uudelleen.equals("n"))){
                System.out.println("Error!");
                System.out.println("Continue (y/n)?");
                //uudelleen = In.readString();
                uudelleen = scan.next();
                if (uudelleen.equals("y")) {
                    stats="";
                    käynnissä = true;
                }
                else if (uudelleen.equals("n")) {
                    System.out.println("See you soon.");
                    käynnissä = false;
                }
            }
        }
    }
}

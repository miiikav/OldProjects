/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omaluokkatesti;

/**
 *
 * @author Tuomo
 */
public class OmaLuokka {
    
   /* 
    * Attribuutit.
    *
    */
    //maa
    private String country;
    //raha
    private double gold;
    //reservi
    private int manpower;
    //noppa
    private int dice;
    //yksiköt
    private int units;
    
   /* 
    * Aksessorit.
    *
    */
       
    public String country() {  
        return country;
    }
       
    public void country(String e) {
       if (e != null) {
           country = e;
       }
    }
    public double gold() {  
        return gold;
    }
        
    public void gold(double e) {
           gold = e;
    }
    
    
    public int manpower() {  
        return manpower;
    }
        
    public void manpower(int e) {
        if (e > 0) {            
            manpower = e;

        }
    }
    
   /* 
    * Metodit.
    *
    */
    //Eivät ole vielä käytössä
    
    //Yksiköiden koulutus
    private void train(){
        if(manpower>1000&&gold>10){
            manpower=manpower-1000;
            gold=gold-10;
            units++;
        }
        
    }
    //Nopanheitto
    private void roll() {
        dice = (int)(Math.random()*6) + 1;
    }
}

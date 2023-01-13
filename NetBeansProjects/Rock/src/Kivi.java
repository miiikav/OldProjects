// *************
// Kivi.java 
// ************* 

import java.util.Scanner; 
import java.util.Random; 


public class Kivi 
{ 
    public static void main(String[] args) { 
        String Tuomo; //User's play -- "K", "P", or "S" 
        String Tietokone = ""; //Computer's play -- "K", "P", or "S" 
        int Random; //Randomly generated number used to determine 
                     //computer's play 
        Boolean käynnissä = true;
        String uudelleen;
    
        Scanner scan = new Scanner(System.in); 
        Random generator = new Random(); 
        while (käynnissä) {
        
        System.out.println("Kivi, Paperi, Sakset!\n" + "Valitse.\n" + "Kivi = K, Paperi" + "= P, tai Sakset = S.");

        System.out.println();

        //Generate computer's play (0,1,2) 
        Random = generator.nextInt(3)+1; 
        //Translate computer's randomly generated play to 
        //string using if //statements 
        switch (Random) {
            case 1:
                Tietokone = "K";
                break;
            case 2:
                Tietokone = "P";
                break; 
            case 3:
                Tietokone = "S";
                break;
            default:
                break;
        }

        System.out.println("Kunka monta kierrosta pelataan:");
        int luku = scan.nextInt();
        int määrä = 0;
        while (määrä<luku){
            Random = generator.nextInt(3)+1;
            switch (Random) {
                case 1:
                    Tietokone = "K";
                    break;
                case 2:
                    Tietokone = "P"; 
                    break;
                case 3:
                    Tietokone = "S";
                    break;
                default:
                    break;
            }
            määrä=määrä+1;
    
        //Get player's play from input-- note that this is 
        // stored as a string 
        System.out.println("\nValitse: "); 
        Tuomo = scan.next();

        //Make player's play uppercase for ease of comparison 
        Tuomo = Tuomo.toUpperCase(); 

        //Print computer's play 
        System.out.println("Tietokone valitsi: " + Tietokone); 


        //See who won. Use nested ifs 

        int voittaja = 0;
    
        if (Tuomo.equals(Tietokone)) {
        System.out.println("Tasapeli!");
        }
        else if (Tuomo.equals("K")) {
            switch (Tietokone) {
                case "S":
                    System.out.println("Kivi voittaa sakset. Voitit!!");
                            voittaja++;
                    break;
                case "P":
                    System.out.println("Paperi voittaa kiven. Hävisit!!");
                            voittaja--;
                    break;
            }

        }
        else if (Tuomo.equals("P")) {
            switch (Tietokone) {
                case "S":
                    System.out.println("Sakset voittavat paperin. Hävisit!!");
                            voittaja--;
                    break;
                case "K":
                    System.out.println("Papeeri voittaaa kiven. Voitit!!");
                            voittaja++;
                    break;
            }

        } 
        else if (Tuomo.equals("S")) {
            switch (Tietokone) {
                case "P":
                    System.out.println("Sakset voittavat paperin. Voitit!!");
                            voittaja++;
                    break;
                case "K":
                    System.out.println("Kivi voittaa sakset. Hävisit!!");
                            voittaja--;
                    break;
            }

        }
        else 
                System.out.println("Error.");
     
            if (määrä==luku){

            if (voittaja>0)
                System.out.println("\nVoitit Pelin!!\n"+voittaja);
            else if (voittaja<0)
                System.out.println("\nHävisit Pelin!!\n"+voittaja);
       
            else
                System.out.println("\nTasapeli!!\n"+voittaja);
       
            System.out.println("Haluatko yrittää udelleen?\n"+"Y=Kyllä\n"+"N=Ei");
            uudelleen = scan.next();
            if (uudelleen.equalsIgnoreCase("Y")) {
                käynnissä = true;
            }
            if (uudelleen.equalsIgnoreCase("N")) {
                käynnissä = false;
            }
            }
   
        }
      }
    }
}
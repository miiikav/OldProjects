/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic8ball;
import java.util.*;
/**
 *
 * @author Tuomo
 */
public class Magic8Ball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am a Magic 8 Ball.");
        System.out.println("Ask me:");
        scan.next();
        Arvonta();

    }
    public static void Arvonta(){
        
        int arvottu = (int)(20 * Math.random()) + 1;
        switch (arvottu) {
            case 1:
                {
                    String vastaus ="It is certain.";
                    System.out.println(vastaus);
                    break;
                }
            case 2:
                {
                    String vastaus ="It is decidedly so.";
                    System.out.println(vastaus);
                    break;
                }
            case 3:
                {
                    String vastaus ="Without a doubt.";
                    System.out.println(vastaus);
                    break;
                }
            case 4:
                {
                    String vastaus ="Yes definitely.";
                    System.out.println(vastaus);
                    break;
                }
            case 5:
                {
                    String vastaus ="You may rely on it.";
                    System.out.println(vastaus);
                    break;
                }
            case 6:
                {
                    String vastaus ="As I see it, yes.";
                    System.out.println(vastaus);
                    break;
                }
            case 7:
                {
                    String vastaus ="Most likely.";
                    System.out.println(vastaus);
                    break;
                }
            case 8:
                {
                    String vastaus ="Outlook good.";
                    System.out.println(vastaus);
                    break;
                }
            case 9:
                {
                    String vastaus ="Yes.";
                    System.out.println(vastaus);
                    break;
                }
            case 10:
                {
                    String vastaus ="Signs point to yes.";
                    System.out.println(vastaus);
                    break;
                }
            case 11:
                {
                    String vastaus ="Reply hazy try again.";
                    System.out.println(vastaus);
                    break;
                }
            case 12:
                {
                    String vastaus ="Ask again later.";
                    System.out.println(vastaus);
                    break;
                }
            case 13:
                {
                    String vastaus ="Better not tell you now.";
                    System.out.println(vastaus);
                    break;
                }
            case 14:
                {
                    String vastaus ="Cannot predict now.";
                    System.out.println(vastaus);
                    break;
                }
            case 15:
                {
                    String vastaus ="Concentrate and ask again.";
                    System.out.println(vastaus);
                    break;
                }
            case 16:
                {
                    String vastaus ="Don't count on it.";
                    System.out.println(vastaus);
                    break;
                }
            case 17:
                {
                    String vastaus ="My reply is no.";
                    System.out.println(vastaus);
                    break;
                }
            case 18:
                {
                    String vastaus ="My sources say no.";
                    System.out.println(vastaus);
                    break;
                }
            case 19:
                {
                    String vastaus ="Outlook not so good.";
                    System.out.println(vastaus);
                    break;
                }
            case 20:
                {
                    String vastaus ="Very doubtful.";
                    System.out.println(vastaus);
                    break;
                }
            default:
                break;
        }

        
        
    }
}

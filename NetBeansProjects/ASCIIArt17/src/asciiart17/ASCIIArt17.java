/*
 * Ohjelma lukee käyttäjän antaman tekstitiedoston ja muuntaa sen taulukoksi,
 * jonka jälkeen käyttäjä pystyy muokkaamaan taulukkoa erilaisilla komennoilla.
 * Tiedoston nimi välitetään ohjelmalle komentoriviparametrina.
 */
package asciiart17;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Tuomo Ikävalko
 */
public class ASCIIArt17 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("| A S C I I A r t 1 7 |");
        System.out.println("-----------------------");
        String command="";
        if(args.length==1){
            try {
                File txtfile= new File(args[0]);
            Scanner lukija = new Scanner(txtfile);
            int m=0;
            int n=0;
            
            while(lukija.hasNextLine()) {
                String rivi = lukija.nextLine(); 
                n=rivi.length();
                m++;
            }
            char[][] kuva = Filler(n,m,txtfile);
            
            while(!command.equals("quit")){
                System.out.println("Please, enter a command:");
                //lukee käyttäjän antaman komennon
                //command=In.readString();
                command=scan.nextLine();
                //muuttaa komennon String taulukoksi
                String[] recolour = command.split(" ");
                if(command.contains("  ")){
                    // Poimitaan värien merkit sillä oletuksella, että komento on laillinen,
                    // jolloin komennolla on kaksi välilyönnein komennosta ja toisistaan
                    // erotettua parametria.
                    char korvattava = command.charAt(9);
                    char korvaava = command.charAt(11);
                    kuva=Recolour(korvattava,korvaava,kuva);
                    //estetään toisen if lauseen toteutuminen.
                    recolour[0]="empty";
                }
                if(command.equals("print")){
                    Print(kuva);
                }
                if(command.equals("info")){
                    Info(kuva);
                }
                if(command.equals("rotater")){
                    kuva=Rotater(kuva);
                }
                if(command.equals("rotatel")){
                    kuva=Rotatel(kuva);
                }
                if(recolour[0].equals("recolour")){             
                    //muutetaan merkit char tyyppiseksi.
                    String first=recolour[1];
                    String second=recolour[2];
                    char firstchar= first.charAt(0);
                    char secondchar= second.charAt(0);
                    //testi
                    //System.out.println("|"+firstchar+"|");
                    //System.out.println("|"+secondchar+"|");
                    kuva=Recolour(firstchar,secondchar,kuva);
                }
                if(command.equals("reset")){
                    kuva = Reset(n,m,txtfile);
                }
            }
            } catch (FileNotFoundException ex) {
                //Tiedostoa ei löydetty tulostetaan viesti ja lopetetaan ohjelma
                System.out.println("Invalid command-line argument!");
            }
            System.out.println("Bye, see you soon.");
        }
        else{
            //Tiedostoa ei löydetty tulostetaan viesti ja lopetetaan ohjelma
            System.out.println("Invalid command-line argument!");
            System.out.println("Bye, see you soon.");
        }
    }

    public static void Print(char[][] print) {
      // Tulostetaan vain, jos taulukolle on varattu muistia.
      if(print!=null){
            int index=0;
            int index2=0;
            while (index<print.length){
                while (index2<print[0].length){     
                    System.out.print(print[index][index2]);
                    index2++;
                }
                System.out.println();
                index2=0;
                index++;
            }
        }
    }

    public static void Info(char[][] kuva) {

            //sijoitetaan merkit yksiulotteiseen taulukkoon.
            char[] merkit = {'#', '@', '&', '$', '%', 'x', '*',
                'o', '|', '!', ';', ':', '\'', ',', '.', ' ' };
            int n=kuva.length;
            int m=kuva[0].length;
            int index1=0;//merkit
            int index2=0;//sarakkeet
            int index3=0;//rivit
            int eka=0;//#
            int toka=0;//@
            int kol=0;//&
            int nel=0;//$
            int vii=0;//%
            int kuu=0;//x
            int see=0;//*
            int kasi=0;//o
            int ysi=0;//|
            int kymppi=0;//!
            int yytoo=0;//;
            int kaatoo=0;//:
            int kootoo=0;//'
            int neetoo=0;//,
            int viitoo=0;//.
            int kuutoo=0;//' '
            while(index3<kuva.length){
                while(index2<kuva[0].length){
                    while(index1<merkit.length){
                        //verrataan jokaista merkkiä taulukon jokaiseen kohtaan
                        //laitetaan muistiin kuinka mona kertaa kutakin merkkiä on esiintynyt
                        if(merkit[index1]==kuva[index3][index2]){
                            if(kuva[index3][index2]=='#'){
                                eka++;
                            }
                            if(kuva[index3][index2]=='@'){   
                                toka++;
                            }
                            if(kuva[index3][index2]=='&'){
                                kol++;
                            }
                            if(kuva[index3][index2]=='$'){
                                nel++;
                            }
                            if(kuva[index3][index2]=='%'){
                                vii++;
                            }
                            if(kuva[index3][index2]=='x'){
                                kuu++;
                            }
                            if(kuva[index3][index2]=='*'){
                                see++;
                            }
                            if(kuva[index3][index2]=='o'){
                                kasi++;
                            }
                            if(kuva[index3][index2]=='|'){
                                ysi++;
                            }
                            if(kuva[index3][index2]=='!'){
                                kymppi++;
                            }
                            if(kuva[index3][index2]==';'){
                                yytoo++;
                            }
                            if(kuva[index3][index2]==':'){
                                kaatoo++;
                            }
                            if(kuva[index3][index2]=='\''){
                                kootoo++;
                            }
                            if(kuva[index3][index2]==','){
                                neetoo++;
                            }
                            if(kuva[index3][index2]=='.'){
                                viitoo++;
                                }
                            if(kuva[index3][index2]==' '){
                                kuutoo++;
                            }
                        }
                        index1++;
                    }
                    index2++;
                    index1=0;
                }
                index3++;
                index2=0;
            }
            System.out.println(n+" x "+m);
            System.out.println("# "+eka);
            System.out.println("@ "+toka);
            System.out.println("& "+kol);
            System.out.println("$ "+nel);
            System.out.println("% "+vii);
            System.out.println("x "+kuu);
            System.out.println("* "+see);
            System.out.println("o "+kasi);
            System.out.println("| "+ysi);
            System.out.println("! "+kymppi);
            System.out.println("; "+yytoo);
            System.out.println(": "+kaatoo);
            System.out.println("' "+kootoo);
            System.out.println(", "+neetoo);
            System.out.println(". "+viitoo);
            System.out.println("  "+kuutoo);

    }

    public static char[][] Rotater(char[][] kuva) {
        if(kuva!=null){
            //kännetään kuva
            final int m=kuva.length;
            final int n=kuva[0].length;
            char[][] kuvar=new char[n][m];
            for (int r=0; r<m; r++) {
                for (int c=0; c<n; c++) {
                    kuvar[c][m-1-r]=kuva[r][c];
                }
            }
            //palautetaan käännetty kuva
            return kuvar;
        }
       else {
          return null;
       }
    }

    public static char[][] Rotatel(char[][] kuva) {
        if(kuva!=null){
            //kännetään kuva
            final int m=kuva.length;
            final int n=kuva[0].length;
            char[][] kuval=new char[n][m];
            for(int r=0; r<n; r++){
                for(int c=0; c<m; c++){
                    kuval[n-1-r][c]=kuva[c][r];
                }
            }
            //palautetaan käännetty kuva
            return kuval;
        }
       else {
          return null;
       }
    }

    public static char[][] Recolour(char firstchar, char secondchar, char[][] kuva) {
        if(kuva!=null){
            int index=0;
            int index2=0;
            int index3=0;
            while(index<kuva.length){
                while(index3<kuva[0].length){
                    //verrataan jokaista taulukon kirjainta korvattavaan kirjaimeen
                    if(kuva[index2][index3]==firstchar){
                        kuva[index2][index3]=secondchar;
                    }
                    index3++;
                }
                index3=0;
                index++;
                index2++;
                
            }
            //operaatio palauttaa joko muutetun kuvan tai tyhjän
            return kuva;
        }
        else{
            return null;
        }
    }

    public static char[][] Reset(int n, int m, File txtfile) {
        //lataa kuvan tekstitiedostosta.
        char[][] kuva = Filler(n,m,txtfile);
        return kuva;
    }

    private static char[][] Filler(int n, int m, File txtfile) {
       // N- ja m-arvojen tarkistuksia.
       if (n>0 && m>0)  {
         char[][] kuva = new char[m][n];
         int index1=0;
         int index2=0;
         try {
            Scanner lukija = new Scanner(txtfile);
            // Luetaan rivit yksi kerrallaan.
            while(lukija.hasNextLine()) {
               String rivi = lukija.nextLine();
               // Sijoitetaan rivin merkit taulukon nykyiselle riville.
               index2 = 0;
               while(index2 < rivi.length()) {
                  kuva[index1][index2] = rivi.charAt(index2);
                  index2++;
               }
               index1++;
            }
         } catch (FileNotFoundException ex) {
            kuva = null;
         }
         //palautetaan viite kuva-taulukkoon
         return kuva;
       }
       else {
          return null;
       }
    }
    
}

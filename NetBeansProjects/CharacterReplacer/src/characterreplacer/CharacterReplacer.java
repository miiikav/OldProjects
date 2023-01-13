/*
 * Korvaa taulukossa olevan kirjaimen toisella kirjaimella.
 */
package characterreplacer;


import java.util.Scanner;

/**
 *
 * @author Tuomo
 */
public class CharacterReplacer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! I am a character replacer.");
        System.out.println("Please, enter the number of rows:");
        int rows=scan.nextInt();
        System.out.println("Please, enter the number of columns:");
        int columns=scan.nextInt();
        //kutsutaan Filler-operaatiota
        char[][] array=Filler(rows,columns);
        if(array==null){
            System.out.println("Error!");
        }
        else{
            System.out.println("Please, enter the first character:");
            char first=scan.next().charAt(0);
            System.out.println("Please, enter the second character:");
            char second=scan.next().charAt(0);
            //kutsutaan Replacer-operaatiota ja paluuarvo sijoitetaan booleaniin
            boolean test=Replacer(array,first,second);
            //jos testi epäonnistuu tulostetaan virhekoodi.
            if(test==false){
            System.out.println("Error!");
            }
            else{
                //lopuksi kutsutaan Print-operaatiota
                Print(array);
            }
        }
    }

    public static char[][] Filler(int rows,int columns) {
        if(rows<=0 || columns<=0){
            return null;
        }
        else{
            Scanner scan = new Scanner(System.in);
            char[][] array = new char[rows][columns];
            int index=1;
            int index2=0;
            int index3=0;
            while(index<array.length+1){
                System.out.println("Please, enter row "+index+":");
                String value = scan.next();
                //luodaan väliaikainen sijoituspaikka kijaimille
                char[] temp=new char [columns];
                temp=value.toCharArray();
                while(index3<array[0].length){
                    // pistetään kijaimet taulukkoon
                    array[index2][index3]=temp[index3]; 
                    index3++;
                }
                index++;
                index2++;
                index3=0;
            }
            return array;
        }

    }
    public static boolean Replacer(char[][] array,char first,char second){
        if(array!=null){
            int index=0;
            int index2=0;
            int index3=0;
            while(index<array.length){
                
                while(index3<array[0].length){
                    //verrataan jokaista taulukon kirjainta korvattavaan kirjaimeen
                    if(array[index2][index3]==first){
                        array[index2][index3]=second;
                    }
                    index3++;
                }
                index3=0;
                index++;
                index2++;
                
            }
            //operaatio palauttaa joko truen tai falsen
            return true;
        }
        else{
            return false;
        }
    }
        
    public static void Print(char[][] array) {
        if(array!=null){
            int index=0;
            int index2=0;
            while (index<array.length){
                while (index2<array[0].length){     
                    System.out.print(array[index][index2]);
                    index2++;
                }
                System.out.println();
                index2=0;
                index++;
            }
        }
    }
    
}

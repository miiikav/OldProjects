
/**
 *
 * @author Oppilas
 */
public class Tehtävä1 {

 public static int kertoRekursiivisesti(int n){

 if(n==1) return 1;
 else{
 return n*kertoRekursiivisesti(n-1);

 }
 }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(kertoRekursiivisesti(10));
    }
    
}

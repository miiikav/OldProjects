
/**
 *
 * @author Oppilas
 */
public class Jäsen {

    private int jnumero;
    private String jnimi;
    private int jbonus;

public Jäsen(int num, String n, int b){
 jnumero = num;
 jnimi = n;
 jbonus = b;
 }


    public String getjnimi(){
 return jnimi;
 }
 
 public int getjnumero(){
 return jnumero;
 }
 
 public int getjbonus(){
 return jbonus;
 }


}


package oope2018ht.tiedostot;

import oope2018ht.apulaiset.Getteri;
import oope2018ht.apulaiset.Setteri;

/**
 * <p>
 * Kuva-luokka.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public class Kuva extends Tiedosto{
    //test
    /*
    * Attribuutit.
    *
    */
    
    private int kuval;
    
    private int kuvak;
    
    /*
    * Rakentajat.
    *
    */
    /**
     * Kuva- luokan parametrillinen rakentaja.
     * @param nimi {@inheritDoc}
     * @param koko {@inheritDoc}
     * @param leveys kuvan leveys
     * @param korkeus kuvan korkeus
     * @throws IllegalArgumentException 
     */
    public Kuva(String nimi, int koko, int leveys, int korkeus)throws IllegalArgumentException {
        super(nimi, koko);
        if(leveys<=1 || korkeus<=1){
            throw new IllegalArgumentException();
        }
        else if(leveys>=1 && korkeus>=1){
            kuval=leveys;
            kuvak=korkeus;
        }

    }


    /* 
    * Aksessorit.
    *
    */
    @Getteri    
    public int kuval() {
        return kuval;
    }
    @Setteri 
    public void kuval(int n)throws IllegalArgumentException {
        if(n<=1){
            throw new IllegalArgumentException();
        }     
        else if(n>=1){
            kuval = n;
        }
    }
    @Getteri
    public int kuvak() {
        return kuvak;
        
    }
    @Setteri 
    public void kuvak(int nn) throws IllegalArgumentException{
        if(nn<=1){
            throw new IllegalArgumentException();
        }
                
        else if(nn>=1){
            kuvak = nn;
        }
    }
    /*
    *  Metodit.
    *
    */
        @Override
    public String toString() {
        return super.toString()+" B "+kuval+"x"+kuvak;
   }
}

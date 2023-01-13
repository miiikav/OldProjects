
package oope2018ht.tiedostot;

import oope2018ht.apulaiset.Getteri;
import oope2018ht.apulaiset.Setteri;

/**
 * <p>
 * Video-luokka.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public class Video extends Tiedosto{
    /*
    * Attribuutit.
    *
    */
    
    private double videopituus;



    
    
    /*
    * Rakentajat.
    *
    */
    /**
     * Video-luokan parametrillinen rakentaja
     * @param nimi {@inheritDoc}
     * @param koko {@inheritDoc}
     * @param vid videon pituus.
     * @throws IllegalArgumentException 
     */
    public Video(String nimi, int koko,double vid) throws IllegalArgumentException{
        super(nimi, koko);
        if(vid<=0){
            throw new IllegalArgumentException();
        }
                
        else if(vid>=0){
            videopituus=vid;
        }
    }

    /* 
    * Aksessorit.
    *
    */
    @Getteri
    public double videopituus() {
        return videopituus;
    }
    @Setteri
    public void videodouble(double videop) throws IllegalArgumentException{
        if(videop<=0){
            throw new IllegalArgumentException();
        }
                
        else if(videop>=0){
            videopituus=videop;
        }
    }
    /*
    *  Metodit.
    *
    */
    @Override
    public String toString() {
        return super.toString()+" B "+videopituus+" s";
   }
}

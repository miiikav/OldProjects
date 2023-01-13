package oope2018ht.tiedostot;

import oope2018ht.apulaiset.Getteri;
import oope2018ht.apulaiset.Setteri;

/**
 * <p>
 * Tiedosto-luokka.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public abstract class Tiedosto {
    /*
    * Attribuutit.
    *
    */
    
    private String tiedostonimi;
    
    private int tiedostokoko;
    
    /*
    * Rakentajat.
    *
    */
    /**
     * Tiedosto- luokan parametrillinen rakentaja.
     * @param nimi tiedoston nimi
     * @param koko tiedoston koko
     * @throws IllegalArgumentException 
     */
    public Tiedosto(String nimi, int koko)throws IllegalArgumentException{
        if(nimi==null || nimi.length()<=1 || koko<=1){
            throw new IllegalArgumentException();
        }
        else{
            tiedostonimi=nimi;
            tiedostokoko=koko;
        }
    }


    /* 
    * Aksessorit.
    *
    */
    @Getteri  
    public String tiedostonimi() {
        return tiedostonimi;
    }
    @Setteri
    public void tiedostonimi(String nimi)throws IllegalArgumentException {
        if(nimi.length()<=1 || nimi==null){
            throw new IllegalArgumentException();
        }
        else if(nimi.length()>=1){
            tiedostonimi = nimi;
        }
    }
    @Getteri
    public int tiedostokoko() {
        return tiedostokoko;
    }
    @Setteri
    public void tiedostokoko(int koko)throws IllegalArgumentException {
        if(koko<=1){
            throw new IllegalArgumentException();
        }
        else if(koko>=1){
            tiedostokoko = koko;
        }
    }
    
    /*
    *  Metodit.
    *
    */
        @Override
    public String toString() {
        return tiedostonimi+" "+tiedostokoko;
   }
}

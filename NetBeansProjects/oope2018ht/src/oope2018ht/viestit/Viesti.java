
package oope2018ht.viestit;

import java.util.Objects;
import oope2018ht.apulaiset.Getteri;
import oope2018ht.apulaiset.Komennettava;
import oope2018ht.apulaiset.Setteri;
import oope2018ht.omalista.OmaLista;
import oope2018ht.tiedostot.Tiedosto;

/**
 * <p>
 * Viesti-luokka.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public class Viesti implements Komennettava<Viesti>, Comparable<Viesti>{

    /*
    * Attribuutit.
    *
    */
    private int tunniste;
    
    private String teksti;
    
    private Viesti viesti;
    
    private Tiedosto liite;
    
    private OmaLista lista;
    
    /*
    * Rakentajat.
    *
    */
    /**
     * Viesti-luokan rakentaja.
     * @param viestinum viestin järjestysnumero.
     * @param teksti viestin sisältö.
     * @param viesti viesti.
     * @param liite viestin liite.
     * @throws IllegalArgumentException 
     */
    public Viesti(int viestinum, String teksti, Viesti viesti, Tiedosto liite)throws IllegalArgumentException {
        if(viestinum<=0 || teksti==null){
            throw new IllegalArgumentException();
        }
        else{
            this.tunniste = viestinum;
            this.teksti = teksti;
            this.viesti = viesti;
            this.liite = liite;
            this.lista = new OmaLista();
        }

    }


    /*
     * Aksessorit.
     *
     */
     @Getteri
    public int tunniste(){
        return tunniste;
    }
    @Setteri
    public void tunniste(int tunniste)throws IllegalArgumentException{
        if(tunniste<=0){
            throw new IllegalArgumentException();
        }
        else{
            this.tunniste=tunniste;
        }
    }
     @Getteri
    public String teksti(){
        return teksti;
    }
    @Setteri
    public void teksti(String teksti)throws IllegalArgumentException{
        if(teksti==null || teksti.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            this.teksti=teksti;
        }
    }
     @Getteri
    public Viesti viesti(){
        return viesti;
    }
    @Setteri
    public void viesti(Viesti viesti){
        this.viesti=viesti;
    }
     @Getteri
    public Tiedosto liite(){
        return liite;
    }
    @Setteri
    public void liite(Tiedosto liite){
        this.liite=liite;
    }
     @Getteri
    public OmaLista lista(){
        return lista;
    }
    @Setteri
    public void lista(OmaLista lista)throws IllegalArgumentException{
        if(lista==null){
            throw new IllegalArgumentException();
        }
        else{
            this.lista=lista;
        }
    }
    /*
     * Metodit.
     *
     */

    /**{@inheritDoc} Viesti luokan hae metodi.
     * 
     * @param haettava {@inheritDoc}
     * @return {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
     @Override
     public Viesti hae(Viesti haettava) throws IllegalArgumentException {
         if(haettava==null){
             throw new IllegalArgumentException();
         }
         else{
             // Tässä tapahtuu rekursiivinen kutsu ja ohjelma kaatuu, koska rekursiosta ei palata. Rekursiota
             // tarvitaan tässä työssä vain ketjun puumaiseen tulostukseen.
             // Viesti paluuarvo=hae(haettava);

             // Haetaan listalta.
             Viesti paluuarvo=(Viesti) lista.hae(haettava);
             if(paluuarvo!=null){
                 return paluuarvo;
             }
             else{
                 return null;
             }
         }
     }
    /**{@inheritDoc} Viesti luokan lisaaVastaus metodi.
     * 
     * @param lisaa {@inheritDoc}
     * @throws IllegalArgumentException 
     */
    @Override
    public void lisaaVastaus(Viesti lisaa) throws IllegalArgumentException {
        if(lisaa==null){
            throw new IllegalArgumentException();
        }
        else{
            // Vastaus on jo listalla.
            if (hae(lisaa) != null) {
                throw new IllegalArgumentException();
            }
            // Vastausta ei löydetty. Voidaan lisätä.
            else {
                lista.lisaaLoppuun(lisaa);
            }
        }
    }
    /**
     * {@inheritDoc} Viesti luokan tyhjenna metodi.
     */
    @Override
    public void tyhjenna() {
        teksti=POISTETTUTEKSTI;
        liite=null;
    }
    /**Viesti luokan compareTo metodi
     * 
     * @param toinen verrattava kohde.
     * @return -1, 0 tai 1 riippuen onko kohde pienempi yhtäsuuri vai suurempi.
     */
    @Override
    public int compareTo(Viesti toinen) {
        if (tunniste < toinen.tunniste()){
             return -1;
        }
        else if (tunniste == toinen.tunniste()) {
              return 0;
        }
        else{
              return 1;
        }
    }
    /**Viesti luokan equals metodi.
     * 
     * @param viesti vertailtava kohde
     * @return true, jos kohde on samanlainen, false jos ei.
     */
    @Override
    public boolean equals(Object viesti){
        if(!(viesti instanceof Viesti)){
            return false;
        }
        else{
            Viesti toinenViesti=(Viesti)viesti;
            if(tunniste==toinenViesti.tunniste){
                return true;
            }
            else{
                return false;
            }
        }
    }
    /** Viesti luokan toString metodi.
     * 
     * @return tulostaa oikeanlaisen tekstin.
     */
    @Override
    public String toString() {
        if(viesti==null && liite!=null){
            return "#"+tunniste+" "+teksti+" ("+liite+")";
        }
        else if(liite==null && viesti!=null){
            return "#"+tunniste+" "+teksti;
        }
        else if(liite==null && viesti==null){
            return "#"+tunniste+" "+teksti;
        }
        else{
            return "#"+tunniste+" "+teksti+" ("+liite+")";
        }
   }
}

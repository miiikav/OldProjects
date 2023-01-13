
package oope2018ht.viestit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import oope2018ht.apulaiset.Getteri;
import oope2018ht.apulaiset.Setteri;
import oope2018ht.omalista.OmaLista;
import oope2018ht.tiedostot.Kuva;
import oope2018ht.tiedostot.Tiedosto;
import oope2018ht.tiedostot.Video;

/**
 * <p>
 * Alue-luokka. Alue luokka sisältää useimmat 
 * käyttöliittymä luokan kutsumat medodit.
 * Näihin kuuluvat lisaaKetju, valinta, tyhjenna, uusiViesti, lisaaVastaus,
 * listaPaa ja -Hanta, Hae, listaa ja tulosta metodit.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public class Alue {
    /*
    * Attribuutit.
    *
    */
    private int ketjulaskuri;
    private int viestilaskuri;
    private OmaLista ketjut;
    private Ketju aktiivinen;
    public static final String POISTETTUTEKSTI = "----------";
    
    
    /*
    * Rakentajat.
    *
    */
    /**
     * Alue-luokan rakentaja.
     */
    public Alue() {
        this.ketjulaskuri = 0;
        this.viestilaskuri = 0;
        this.ketjut = new OmaLista();
        this.aktiivinen = null;
    }


    /*
     * Aksessorit.
     *
     */

    @Getteri
    public int getKetjulaskuri() {
        return ketjulaskuri;
    }

    @Setteri
    public void setKetjulaskuri(int ketjulaskuri) {
        this.ketjulaskuri = ketjulaskuri;
    }

    @Getteri
    public int getViestilaskuri() {
        return viestilaskuri;
    }

    @Setteri
    public void setViestilaskuri(int viestilaskuri) {
        this.viestilaskuri = viestilaskuri;
    }

    @Getteri
    public OmaLista getKetjut() {
        return ketjut;
    }

    @Setteri
    public void setKetjut(OmaLista ketjut) {
        this.ketjut = ketjut;
    }

    @Getteri
    public Ketju getAktiivinen() {
        return aktiivinen;
    }

    @Setteri
    public void setAktiivinen(Ketju aktiivinen) {
        this.aktiivinen = aktiivinen;
    }
    
    /*
     * Metodit.
     *
     */
    
    /** Lisää uuden viestiketjun.
     * 
     * 
     * @param aihe ketjun aihe.
     * @throws IllegalArgumentException jos, aihe on tyhjä.
     */
    public void lisaaKetju(String aihe)throws IllegalArgumentException{
       if(aihe==null){
           throw new IllegalArgumentException();
       }
       Ketju uusi = new Ketju(++ketjulaskuri, aihe);
       ketjut.lisaaLoppuun(uusi);
       if(ketjulaskuri==1){
           aktiivinen = uusi;
       }
    }
    /**
     * Valitsee annetun viestiketjun.
     * 
     * @param kohta kohta ketjujen listassa.
     * @throws IllegalArgumentException jos kohta on virhellinen.
     */
    public void valinta(int kohta)throws IllegalArgumentException{
        if(kohta<1 || kohta>ketjulaskuri){
            throw new IllegalArgumentException();
        }
        aktiivinen=(Ketju) ketjut.alkio(kohta-1);
    }
    /**
     * Korvaa viestin tekstin viivoilla, sekä poistaa tarvittaessa liitteen.
     * 
     * @param kohta kohta viestilistassa.
     * @throws IllegalArgumentException jos kohta on virhellinen.
     */ 
    public void tyhjenna(int kohta) throws IllegalArgumentException{
        if(kohta <=0 || kohta > viestilaskuri) {
            throw new IllegalArgumentException();
        }
        else {
            // Apulainen, jota käytetään vain hakemiseen. Vain tunnisteella on väliä, koska viestejä
            // verratessa (equals) verrataan vain tunnuksia.
            Viesti haettava = new Viesti(kohta, "x", null, null);
            // Haetaan ketjusta viestiä, johon vastataan.
            Viesti sensuroitava = (Viesti)aktiivinen.getKaikki().hae(haettava);

            // Löydettiin sensuroitava viesti.
            if (sensuroitava != null) {
                // Tyhjätään teksti asettamalla attribuutin arvoksi väliviivoja.
                sensuroitava.teksti(POISTETTUTEKSTI);
                // Poistetaan liite.
                sensuroitava.liite(null);
            }

            // Ei löydetty.
            else{
                throw new IllegalArgumentException();
            }
        }
    }
    /**
     * Lisää uuden viestin nykyiseen ketjuun.
     * 
     * @param teksti viestin sisältö.
     * @param nimi liitetiedoston nimi.
     * @throws IllegalArgumentException jos viesti on tyhjä.
     */
    public void uusiViesti(String teksti,String nimi)throws IllegalArgumentException{
        if(teksti==null){
            throw new IllegalArgumentException();
        }
        else if(nimi!=null){
            Tiedosto liite = tiedostoHaku(nimi);
            //tarkistetaan löytyikö tiedosto.
            if(liite==null){
            }
            else{
                Viesti uusi = new Viesti(++viestilaskuri, teksti, null, liite);
                aktiivinen.getKaikki().lisaa(uusi);
                aktiivinen.getOksat().lisaa(uusi);
            }
        }
        else{
            Viesti uusi = new Viesti(++viestilaskuri, teksti, null, null);
            aktiivinen.getKaikki().lisaa(uusi);
            aktiivinen.getOksat().lisaa(uusi);
        }


    }
    /**
     * Hakee tarvittavan liitteen annetun nimen perusteella.
     * 
     * @param nimi tarvittavan liitteeen nimi.
     * @return tarvittavan liitteen tiedot.
     */
    public Tiedosto tiedostoHaku(String nimi){
        Tiedosto liite = null;
        //String[] kuvatyypit= new String[]{".jpg",".gif"};
        try {
            File txtfile= new File(nimi);
            Scanner lukija = new Scanner(txtfile);
            String sisalto= lukija.nextLine();
            if(sisalto.contains("Kuva")){
                String [] erottaja = sisalto.split(" ");
                String kokoString=erottaja[1];
                String leveysString=erottaja[2];
                String korkeusString=erottaja[3];
                int koko = Integer.parseInt(kokoString);
                int leveys = Integer.parseInt(leveysString);
                int korkeus = Integer.parseInt(korkeusString);
                liite = new Kuva(nimi,koko,leveys,korkeus);
            }
            else if(sisalto.contains("Video")){
                String [] erottaja = sisalto.split(" ");
                String kokoString=erottaja[1];
                String pituusString=erottaja[2];
                int koko = Integer.parseInt(kokoString);
                double pituus = Double.parseDouble(pituusString);
                liite = new Video(nimi,koko,pituus);
            }
            else{
                throw new FileNotFoundException();
            }
        }
        catch (FileNotFoundException ex) {
        //Tiedostoa ei löydetty.
        System.out.println("Error!");
        }
        return liite;
    }
    /**
     *  Vastaa halutun viestiin uudella viestillä.
     * @param numero viestin kohteen sijainti viestilistassa.
     * @param vastaus vastauksen sisältö.
     * @param nimi vastauksen liitetiedoston nimi.
     * @throws IllegalArgumentException jos kohde on väärä tai vastaus on tyhjä.
     */

    public void lisaaVastaus(int numero, String vastaus, String nimi) throws IllegalArgumentException{
        if(numero<1||vastaus==null || numero > viestilaskuri){
            throw new IllegalArgumentException();
        }
        // Apulainen, jota käytetään vain hakemiseen. Vain tunnisteella on väliä, koska viestejä
        // verratessa (equals) verrataan vain tunnuksia.
        Viesti haettava = new Viesti(numero, "x", null, null);
        // Haetaan ketjusta viestiä, johon vastataan.
        Viesti vastattava = (Viesti)aktiivinen.getKaikki().hae(haettava);
        // Vastattava löytyi.
        if (vastattava != null) {
            Tiedosto liite = null;
            // Kutsutaan tiedosto-olion luovaa operaatiota.
            //Oletaan paluuarvon olevan null, jos tiedostoa ei löydetä.
            if (nimi != null) {
                 liite = tiedostoHaku(nimi);
                 //Tarkistetaan, että liite ei ole tyhjä.
                 if(liite==null){
                 }
                 else{
                     Viesti uusi = new Viesti(++viestilaskuri, vastaus, vastattava, liite);
                     
                    // Muistetaan lisätä uusi viesti vastatun viestin listalle.
                    vastattava.lisaaVastaus(uusi);

                    // Lisätään uusi viesti ketjun kaikkien viestien listalle.
                    aktiivinen.getKaikki().lisaa(uusi);
                 }
            }
            else{
                Viesti uusi = new Viesti(++viestilaskuri, vastaus, vastattava, liite);
                
                // Muistetaan lisätä uusi viesti vastatun viestin listalle.
                vastattava.lisaaVastaus(uusi);

                // Lisätään uusi viesti ketjun kaikkien viestien listalle.
                aktiivinen.getKaikki().lisaa(uusi);
            }


        }
        else {
            System.out.println("Error!");
        }
    }
    /**
     * Tulostaa viestejä annetun määrän alkaen viestilistan päästä.
     * 
     * @param numAlusta määrittää viestien määrän.
     * @throws IllegalArgumentException jos määrä on liian pieni.
     */
    public void listaPaa(int numAlusta) throws IllegalArgumentException{
        if(numAlusta<1){
            throw new IllegalArgumentException();
        }
        OmaLista alku= aktiivinen.getKaikki().annaAlku(numAlusta);
        int i = 0;
        while(alku.koko()>i){
            System.out.println(alku.alkio(i));
            i++;
        }
        
    }
    /**
     * Tulostaa viestejä annetun määrän alkaen viestilistan hännästä.
     * 
     * @param numLopusta määrittää viestien määrän.
     * @throws IllegalArgumentException jos määrä on liian pieni.
     */
    public void listaHanta(int numLopusta) throws IllegalArgumentException{
        if(numLopusta<1){
            throw new IllegalArgumentException();
        }
        OmaLista loppu=aktiivinen.getKaikki().annaLoppu(numLopusta);
        int i = 0;
        while(loppu.koko()>i){
            System.out.println(loppu.alkio(i));
            i++;
        }
    }
    /**
     * Hakee annettua merkkijonoa viesteistä ja tulostaa löydetyt viestit.
     * 
     * @param haettava haettava merkkijono.
     * @throws IllegalArgumentException jos haettava on tyhjä.
     */
     public void hae(String haettava) throws IllegalArgumentException{
         if(haettava==null){
             throw new IllegalArgumentException();
         }
         else {
             // Esiehto estää haun, kun lista on tyhjä.
             int i=0;
             OmaLista viestit = aktiivinen.getKaikki();
             // Hae tässä vain aktiivisesta ketjusta.
             while (i < viestit.koko()) {
                 if (viestit.alkio(i).toString().contains(haettava)) {
                     System.out.println(viestit.alkio(i));
                 }
                 i++;
             }
         }
     }
    /**
     * 
     * Tulostaa nykyisen ketjun kaikki viestit kirjoitusjärjestyksessä.
     */
    public void listaa(){
        
        OmaLista viestit = aktiivinen.getKaikki();
        System.out.println("=");
        System.out.println("== "+aktiivinen);
        System.out.println("===");
        
        for (int ind = 0; ind < viestit.koko(); ind++){
            System.out.println(viestit.alkio(ind));
        }
    }
    /**
     *
     * Tulostaa kaikki ketjut, mutta ei viestejä.
     */
    public void tulosta() {
       for (int ind = 0; ind < ketjut.koko(); ind++) {
          // Tulostetaan näytölle ketjujen merkkijonoesitykset.
          System.out.println(ketjut.alkio(ind));
       }
    }
    /**
     * Alue luokka kutsuu tulosta puuna metodia.
     */
    public void tulostaPuuna() {
        System.out.println("=");
        System.out.println("== "+aktiivinen);
        System.out.println("===");
        aktiivinen.tulostaPuuna();
    }
}

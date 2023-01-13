
package oope2018ht.viestit;

import oope2018ht.apulaiset.Getteri;
import oope2018ht.apulaiset.Setteri;
import oope2018ht.omalista.OmaLista;

/**
 * <p>
 * Ketju-luokka.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public class Ketju {


    
    /*
    * Attribuutit.
    *
    */
    
    private int tunnus;
    private String aihe;
    private OmaLista oksat;
    private OmaLista kaikki;
    
    
    /*
    * Rakentajat.
    *
    */
    /**
     * Ketju- luokan rakentaja.
     * @param tunnus ketjun järjestysnumero
     * @param aihe ketjun otsikko
     */
    public Ketju(int tunnus, String aihe)throws IllegalArgumentException{
        if(aihe==null){
            throw new IllegalArgumentException();
        }
        this.tunnus = tunnus;
        this.aihe = aihe;
        this.oksat = new OmaLista();
        this.kaikki = new OmaLista();
        
    }

    public Ketju() {
    }

    /*
     * Aksessorit.
     *
     */
    
    @Getteri
    public int getTunnus() {
        return tunnus;
    }
    
    @Setteri
    public void setTunnus(int tunnus) {
        this.tunnus = tunnus;
    }

    @Getteri
    public String getAihe() {
        return aihe;
    }

    @Setteri
    public void setAihe(String aihe) {
        this.aihe = aihe;
    }

    @Getteri
    public OmaLista getOksat() {
        return oksat;
    }
    @Setteri
    public void setOksat(OmaLista oksat) {
        this.oksat = oksat;
    }
    
    @Getteri
    public OmaLista getKaikki() {
        return kaikki;
    }
    
    @Setteri
    public void setKaikki(OmaLista kaikki) {
        this.kaikki = kaikki;
    }
    
    /*
     * Metodit.
     *
     */
    /**
     * tulostaPuuna-metodi.
     * Tulostaa nykyisen ketjun ja sen viestit puumaisesti eli normaalit viestit
     * alimmaisena ja niihin vastaavat viestit viistosti viiden alapuolella.
     */
    public void tulostaPuuna() {
        // Käydään läpi viestiketjun oksaviestit säilövä lista.
        int i = 0;
        while (i < oksat.koko()) {
            
            // Kutsutaan rekursiivista tulostusalgoritmia.
            tulostaPuuna((Viesti) oksat.alkio(i), 0);
            i++;
        }
    }
    /** Rekursiivinen tulostusalgoritmi.
     * tulostaPuuna metodi kutsuu itseään.
     * 
     * @param viesti Nykyinen viesti.
     * @param syvyys haluttu syvennys.
     */
    public void tulostaPuuna(Viesti viesti, int syvyys) {        // Tulostetaan annetun syvyinen sisennys.
        tulosta(syvyys);
        // Tulostetaan viestin merkkijonoesitys.
        System.out.println(viesti);
        // Asetetaan apuviite viestin vastaukset säilövään listaan.
        OmaLista vastaavat = viesti.lista();
        // Tulostetaan vastaukset rekursiivisesti. Metodista palataan,
        // kun vastauslista on tyhjä.
        int j = 0;
        while (j < vastaavat.koko()) { 
            
            tulostaPuuna((Viesti) vastaavat.alkio(j), syvyys +3);
    
            j++;
        }
    
    }
    /**Metodi, joka tulostaa määritetyn kokoisen syvennyksen.
     * 
     * @param syvyys haluttu syvennys.
     */
    public void tulosta(int syvyys) {
        int i=0;
        while(syvyys>i){
            System.out.print(" ");
            i++;
        }
    }
    @Override
    public String toString() {
       return "#" + tunnus + " " + aihe + " (" + kaikki.koko() + " messages)";
    }
}


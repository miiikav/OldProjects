package oope2018ht;

import oope2018ht.apulaiset.In;
import oope2018ht.viestit.Alue;

/**
 * <p>
 * Käyttöliittymä-luokka.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public class Kayttoliittyma {
    /** Ohjelman komennot kulkevat pääsilmukan kautta
     * muille ohjelman osa-alueille, pääasiassa Alue luokalle.
     *
     */
    public void Paasilmukka()  {
        boolean kaynnissa=true;
        Alue alue = new Alue();
        System.out.println("Welcome to S.O.B.");
        String syote;
        //Silmukka pysyy käynnissä kunnes käyttäjä pysäyttää sen
        while(kaynnissa==true){
            try{
            System.out.print(">");
            syote=In.readString();
            if(syote.equals("exit")){
                System.out.println("Bye! See you soon.");
                kaynnissa=false;
            }
            //ketjun liäystä varten.
            else if(syote.startsWith("add")){
                String uusiSyote=Poistaja(syote);
                alue.lisaaKetju(uusiSyote);
            }
            else if(syote.equals("catalog")){
                alue.tulosta();
            }
            //ketjun valintaa varten.
            else if(syote.startsWith("select")){
                String uusiSyote=Poistaja(syote);
                    int numSyote = Integer.parseInt(uusiSyote);
                    alue.valinta(numSyote);
            }
            //uutta viestiä varten.
            else if(syote.startsWith("new")){
                //syöte pilkotaan pienemmiksi osiksi käsittelyn helpottamiseksi.
                String uusiSyote=Poistaja(syote);
                if (uusiSyote.contains(" &")){     
                    String [] poistaja = uusiSyote.split(" &", 2);
                    String teksti = poistaja[0];
                    String tiedostonNimi= poistaja[1];
                    alue.uusiViesti(teksti, tiedostonNimi);
                }
                else{
                    alue.uusiViesti(uusiSyote, null);
                }
            }
            //viestiin vastaamista varten.
            else if(syote.startsWith("reply")){
                //syöte pilkotaan pienemmiksi osiksi käsittelyn helpottamiseksi.
                String uusiSyote=Poistaja(syote);
                String [] erottaja = uusiSyote.split(" ", 2);
                String stringNumero = erottaja[0];
                int numero = Integer.parseInt(stringNumero);
                uusiSyote = erottaja[1];
                if (uusiSyote.contains(" &")){     
                    String [] poistaja = uusiSyote.split(" &", 2);
                    String teksti = poistaja[0];
                    String tiedostonNimi= poistaja[1];
                    alue.lisaaVastaus(numero, teksti, tiedostonNimi);
                }
                else{
                    alue.lisaaVastaus(numero, uusiSyote, null);
                }
            }
            //puumaista tulostamista varten.
            else if(syote.equals("tree")){
                alue.tulostaPuuna();
            }
            //listamaista tuostamista varten.
            else if(syote.equals("list")){
                alue.listaa();
            }
            //viestien tulostamista päästä tai hännästä lähtien.
            else if(syote.startsWith("head")){
                String uusiSyote=Poistaja(syote);
                int numSyote = Integer.parseInt(uusiSyote);
                alue.listaPaa(numSyote);
            }
            else if(syote.startsWith("tail")){
                String uusiSyote=Poistaja(syote);
                int numSyote = Integer.parseInt(uusiSyote);
                alue.listaHanta(numSyote);
            }
            //sanojen etsimistä viesteistä.
            else if(syote.startsWith("find")){
                String uusiSyote=Poistaja(syote);
                alue.hae(uusiSyote);
            }
            //viestien tyhjentämistä varten.
            else if(syote.startsWith("empty")){
                String uusiSyote=Poistaja(syote);
                int numSyote = Integer.parseInt(uusiSyote);
                alue.tyhjenna(numSyote);
            }
            else{
                System.out.println("Error!");
            }
            }
            //Käyttäjän virheet käsitellään täällä
            catch(IllegalArgumentException | ArrayIndexOutOfBoundsException | NullPointerException ex){
                System.out.println("Error!");
            }
        }
    }
    /** Metodi, joka poistaa komennon syöteestä.
     * 
     * @param syote komento ja syöte.
     * @return pelkkä syöte
     */
    public String Poistaja(String syote){
        String [] poistaja = syote.split(" ", 2);
        String uusiSyote= poistaja[1];
        return uusiSyote;
    }
    
}
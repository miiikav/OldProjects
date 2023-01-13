
package oope2018ht.omalista;

import fi.uta.csjola.oope.lista.LinkitettyLista;
import oope2018ht.apulaiset.Ooperoiva;

/**
 * <p>
 * OmaLista-luokka.
 * <p>
 * Harjoitustyö, Olio-ohjelmoinnin perusteet, kevät 2018.
 * <p>
 * @author Tuomo Ikävalko (Ikavalko.Tuomo.J@student.uta.fi)
 */
public class OmaLista extends LinkitettyLista implements Ooperoiva<OmaLista>{
    
    /*
     * Metodit.
     *
     */
    /**{@inheritDoc} OmaLista- luokan Hae metodi.
     * 
     * @param haettava {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public Object hae(Object haettava) {
        int i=0;
        Object uusiAlkio = "";
        if(koko<1){
            return null;
        }
        else{
            while(koko>i){
                if(haettava.equals(alkio(i))){
                    uusiAlkio=alkio(i);
                    i=koko;
                }
                else{
                    i++;
                }
            }
            if(uusiAlkio==null || uusiAlkio==""){
                return null;
            }
            else{
                return uusiAlkio;
            }
        }
    }
    /**{@inheritDoc} OmaLista- luokan lisaa metodi.
     * 
     * @param uusi {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public boolean lisaa(Object uusi) {
        if(uusi==null || !(uusi instanceof Comparable)){
            return false;
        }
        else{
            Comparable vertailtava =(Comparable)uusi;
            boolean loydetty = false;
            int i=0;
            while(koko()>i && !loydetty){
                if(vertailtava.compareTo(alkio(i))<0){
                    lisaa(i,uusi);
                    loydetty=true;
                }
                i++;
            }
            if(!loydetty){
                lisaaLoppuun(uusi);
            }
            return true;
        }
    }
    /**{@inheritDoc} OmaLista- luokan annaAlku metodi.
     * 
     * @param n {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public OmaLista annaAlku(int n) {
        if(n<=0 || koko==0 || n>koko){
            return null;
        }
        else{
            OmaLista listaAlku = new OmaLista();
            for(int i=0; i<n; i++){
                listaAlku.lisaaLoppuun(alkio(i));
            }
            return listaAlku;
        }
    }
    /** {@inheritDoc} OmaLista- luokan annaLoppu metodi.
     * 
     * @param n {@inheritDoc}
     * @return  {@inheritDoc}
     */
    @Override
    public OmaLista annaLoppu(int n) {
        if(n<=0 || koko==0 || n>koko){
            return null;
        }
        else{
            OmaLista listaLoppu = new OmaLista();
            for(int i=koko-n; i<koko; i++){
                listaLoppu.lisaaLoppuun(alkio(i));
            }
            return listaLoppu;
        }   
    }
}

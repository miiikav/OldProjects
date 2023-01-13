package fi.uta.csjola.oope.lista;

/**
  * Yhteen suuntaan linkitetty lista.
  * <p>
  * Alkiot voivat olla null-arvoisia.
  * <p>
  * Olio-ohjelmoinnin perusteet.
  * <p>
  * Viimeksi muutettu 11.2.2014 14.37: lisaa-operaatioon lis�tty
  * erikoistapauksen k�sittely, jotta metodi toimisi samoin kuin
  * vastineensa Javan kokoelmaluokissa.
  * <p>
  * @author Jorma Laurikkala (jorma.laurikkala@uta.fi),
  * Informaatiotieteiden yksikk�, Tampereen yliopisto.
  */

public class LinkitettyLista extends AbstraktiLista {

   /*=============================================================
    *
    * Olioattribuutit
    *
    */

   /** Listan p��. */
   private Solmu paa;

   /** Listan h�nt�. */
   private Solmu hanta;

   /*=============================================================
    *
    * Rakentajat
    *
    */

   /** Alustetaan paa- ja hanta-attribuutit <b>null</b>-arvoihin.
     *
     */
   public LinkitettyLista() {
      paa = null;
      hanta = null;
   }

   /*=============================================================
    *
    * Aksessorit
    *
    */

   /** Palauttaa listan p��n. Vain j�lkel�isten k�ytt��n.
     *
     * @return paa-attribuutin arvo.
     */
   protected Solmu paa() {
      return paa;
   }

   /** Palauttaa listan h�nn�n. Vain j�lkel�isten k�ytt��n.
     *
     * @return hanta-attribuutin arvo.
     */
   protected Solmu hanta() {
      return hanta;
   }

   /*=============================================================
    *
    * Apumetodit.
    *
    */

   /** Palauttaa annetussa paikassa olevan solmun.
     * Mik�li paikka on virheellinen, paluuarvo on null.
     *
     * @param paikka solmun paikka listassa.
     * @return solmu tai null.
     */
   private Solmu haeSolmu(int paikka) {
      // Paikka kunnollinen.
      if (paikkaOK(paikka)) {

         // Aloitetaan listan p��st�.
         Solmu paikassa = paa;

         // Kelataan oikeaan kohtaan.
         for (int i = 0; i < paikka; i++)
            paikassa = paikassa.seuraava();

         // Palautetaan.
         return paikassa;
      }

      // Virheellinen paikka.
      else
         return null;
   }

   /*=============================================================
    *
    * Listan operaatioiden korvaukset.
    *
    */

   /** {@inheritDoc}
     *
     * @param alkio {@inheritDoc}
     */
   public void lisaaAlkuun(Object alkio) {
      // Luodaan uusi solmu.
      Solmu uusi = new Solmu(alkio);

      // Tyhj� lista: p�� ja h�nt� ovat sama alkio.
      if (onkoTyhja()) {
         paa = uusi;
         hanta = uusi;
      }
      // Listassa on jo alkioita.
      else {
         // Uusi solmu osoittamaan p��h�n.
         uusi.seuraava(paa);

         // Uusi solmu listan p��ksi.
         paa = uusi;
      }

      // Kasvatetaan listan kokoa yhdell�.
      koko++;
   }

   /** {@inheritDoc}
     *
     * @param alkio {@inheritDoc}
     */
   public void lisaaLoppuun(Object alkio) {
      // Luodaan uusi solmu.
      Solmu uusi = new Solmu(alkio);

      // Tyhj� lista: p�� ja h�nt� ovat sama alkio.
      if (onkoTyhja()) {
         paa = uusi;
         hanta = uusi;
      }
      // Listassa on jo alkioita.
      else {
         // H�nt� osoittamaan uuteen alkioon.
         hanta.seuraava(uusi);
         // Uusi alkio h�nn�ksi.
         hanta = uusi;
      }

      // Kasvatetaan listan kokoa yhdell�.
      koko++;
   }

   /** {@inheritDoc}
     *
     * @param paikka {@inheritDoc}
     * @param alkio {@inheritDoc}
     * @return {@inheritDoc}
     */
   public boolean lisaa(int paikka, Object alkio) {

      // Oikeellinen lis�yspaikka tai lis�t��n tyhj�n listan "alkuun".
      if (paikkaOK(paikka) || (koko == 0 && paikka == 0)) {

         // P��n paikka tai listassa tasan yksi alkio.
         if (paikka == 0 || koko == 1)
            lisaaAlkuun(alkio);

         // Jokin muu kuin p��n paikka listassa, jonka koko > 1.
         else {

            // Luodaan uusi solmu.
            Solmu uusi = new Solmu(alkio);

            // Haetaan paikassa olevaa solmua edelt�v� solmu.
            Solmu edeltava = haeSolmu(paikka - 1);

            // Paikassa oleva solmu.
            Solmu paikassa = edeltava.seuraava();

            // Asetetaan uusi solmu viittaamaan paikan solmuun.
            uusi.seuraava(paikassa);

            // Asetetaan edellinen solmu viittaamaan uuteen solmuun
            // paikassa olevan solmun asemasta.
            edeltava.seuraava(uusi);

            // Kasvatetaan listan kokoa yhdell�.
            koko++;
         }

         // Lis��minen onnistui.
         return true;
      }

      // Virheellinen lis�yspaikka.
      else
         return false;
   }

   /** {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
   public Object poistaAlusta() {

      // On jotain poistettavaa.
      if(!onkoTyhja()) {
         // Asetetaan apuviite p��h�n, jotta poistettavaa solmua ei hukata.
         Solmu poistettava = paa;

         // Jos listassa vain yksi solmu, niin paa == hanta == null.
         if (koko == 1)
            paa = hanta = null;

         // Listassa on kaksi tai useampia solmuja.
         else
            // Seuraavasta solmusta uusi p��.
            paa = paa.seuraava();

         // V�hennet��n listan kokoa yhdell�.
         koko--;

         // Palautetaan tietoalkio.
         return poistettava.alkio();
      }

      // Tyhj� lista.
      else
         return null;
   }

   /** {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
   public Object poistaLopusta() {

      // On jotain poistettavaa.
      if(!onkoTyhja()) {
         // Asetetaan apuviite h�nt��n, jotta poistettavaa solmua ei hukata.
         Solmu poistettava = hanta;

         // Jos listassa vain yksi solmu, niin paa == hanta == null.
         if (koko == 1)
            paa = hanta = null;

         // Listassa on viel� solmuja.
         else {
            // Edellisest� solmusta uusi h�nt�.
            hanta = haeSolmu(koko - 2);

            // Poistetaan viite vanhaan h�nt��n.
            hanta.seuraava(null);
         }

         // V�hennet��n listan kokoa yhdell�.
         koko--;

         // Palautetaan tietoalkio.
         return poistettava.alkio();
      }

      // Tyhj� lista.
      else
         return null;
   }

   /** {@inheritDoc}
     *
     * @param paikka {@inheritDoc}
     * @return {@inheritDoc}
     */
   public Object poista(int paikka) {

      // Oikeellinen poistopaikka.
      if (paikkaOK(paikka)) {

         // P��n paikka tai listassa tasan yksi alkio.
         if (paikka == 0 || koko == 1)
            return poistaAlusta();

         // H�nn�n paikka.
         else if (paikka == koko - 1)
            return poistaLopusta();

         // Jokin muu kuin p��n tai h�nn�n paikka listassa, jonka koko > 1.
         else {
            // Haetaan poistettavaa solmua edelt�v� solmu.
            Solmu edeltava = haeSolmu(paikka - 1);

            // Poistettava solmu.
            Solmu poistettava = edeltava.seuraava();

            // Asetetaan edellinen solmu viittaamaan poistettavaa solmua
            // seuraavaan solmuun, jolloin poistettava solmu linkitet��n pois.
            edeltava.seuraava(poistettava.seuraava());

            // V�hennet��n listan kokoa yhdell�.
            koko--;

            // Palautetaan alkio.
            return poistettava.alkio();
         }
      }

      // Virheellinen poistopaikka.
      else
         return null;
   }

   /** {@inheritDoc}
     *
     * @param paikka {@inheritDoc}
     * @return {@inheritDoc}
     */
   public Object alkio(int paikka) {
      Solmu paikassa = haeSolmu(paikka);
      if (paikassa != null)
         return paikassa.alkio();
      else
         return null;
   }

   /** {@inheritDoc}
     *
     * @param paikka {@inheritDoc}
     * @param alkio {@inheritDoc}
     * @return {@inheritDoc}
     */
   public Object korvaa(int paikka, Object alkio) {

      // Haetaan annetussa paikassa oleva solmu.
      Solmu paikassa = haeSolmu(paikka);

      // Paikka oli kunnollinen.
      if (paikassa != null) {

         // Otetaan vanha alkio talteen.
         Object vanhaAlkio  = paikassa.alkio();

         // Korvataan vanha alkio uudella.
         paikassa.alkio(alkio);

         // Palautetaan vanha alkio.
         return vanhaAlkio;
      }

      // Paikka oli virheellinen.
      else
         return null;
   }
}

//Kaari Constructor muokattu
//Juurisolmu graafiin
//Muokattu poistometodia


/** Graafi muodostuu solmuista ja niitä yhdistävistä kaarista.
 * Solmun tyyppi on V ja kaaren leiman tyyppi on L.
 */
public class Graafi<V, L>
{
//-- Sisäluokat
    /** Kahden solmun välinen kaari, joka voidaan varustaa leimalla.
     */
    public class Kaari
    {

//-- Konstruktorit
        /** Alustaa leimallsoa varustetun kaaren.
         * @.pre (annaSolmut.contains(u) & v != null)
         * @.post annaLähtösolmu() == u & annaTulosolmu() == v &
         * annaLeima() == leima
         *
         * Muutettu
         */

        protected Kaari(V u, V v, L leima)

//-- Havainnointioperaatiot
        /** Palauttaa kaaren lähtösolmun.
         * @.pre true
         * @.post RESULT == (lähtösolmu)
         *
         * Ei Muutettu
         */
        public V annaLähtösolmu()
        /** Palauttaa kaaren tulosolmun.
         * @.pre true
         * @.post RESULT == (tulosolmu)
         *
         * Ei Muutettu
         */
        public V annaTulosolmu()
        /** Palauttaa kaaren leiman.
         * @.pre true
         * @.post RESULT == (kaaren leima; voi olla null)
         *
         * Ei Muutettu
         */
        public L annaLeima()
    } // class Kaari

//-- Konstruktorit
    /** Alustaa tyhjän (suunnatun) graafin.
     * @.pre true
     * @.post annaSolmut().size() == 1 & annaKaaret().size() == 0
     *
     * Muutettu Vaihdettiin size == 1
     */
    public Graafi()
//-- Havainnointioperaatiot
    /** Palauttaa graafin solmujoukon.
     * @.pre true
     * @.post RESULT == (graafin solmut)
     *
     * Ei muutettu
     */

    public

    public Set<V> annaSolmut()
    /** Palauttaa graafin kaarijoukon.
     * @.pre true
     * @.post RESULT == (graafin kaaret)
     *
     * Ei muutettu
     */
    public Set<Kaari> annaKaaret()
    /** Palauttaa onko kaari graafissa.
     * @.pre true
     * @.post RESULT == annaKaaret().contains(
     * new Graafi.Kaari(u, v, eiVäliä))
     *
     * Ei muutettu
     */
    public boolean sisältääKaaren(V u, V v)
    /** Palauttaa annetun kaaren.
     * @.pre sisältääKaaren(u, v)
     * @.post RESULT.annaLähtösolmu().equals(u) &
     * RESULT.annaTulosolmu().equals(v)
     *
     * Ei muutettu
     */
    public Kaari annaKaari(V u, V v)

    /** Palauttaa solmusta lähtevät kaaret.
     * @.pre annaSolmut().contains(u)
     * @.post FORALL(e : RESULT; e.annaLähtösolmu().equals(v)) &
     * !EXISTS(e : annaKaaret();
     * e.annaLähtösolmu().equals(v) & !RESULT.contains(e))
     *
     * Muokattu v -> u:ksi
     */
    public Set<Kaari> annaLähtevätKaaret(V v)

    /** Palauttaa solmuun saapuvat kaaret.
     * @.pre annaSolmut().contains(v)
     * @.post FORALL(e : RESULT; e.annaTulosolmu().equals(v)) &
     * !EXISTS(e : annaKaaret();
     * e.annaTulosolmu().equals(v) & !RESULT.contains(e))
     *
     * Ei muokattu
     */

    public Set<Kaari> annaSaapuvatKaaret(V v)
//-- Muunnosoperaatiot
    /** Lisää solmun.
     * @.pre !annaSolmut().contains(v)
     * @.post annaSolmut().contains(v)
     *
     * Ei muokattu
     */
    public void lisääSolmu(V v)

    /** Poistaa solmun.
     * @.pre annaSolmut().contains(v) &
     * (annaLähtevätKaaret(v).size() == 0 &
     * annaSaapuvatKaaret(v).size() == 0)
     * @.post !annaSolmut().contains(v)
     *
     * Ei muokattu
     */

    public void poistaSolmu(V v)

    /** Lisää leimalla varustetun kaaren.
     * @.pre (annaSolmut().contains(u) & annaSolmut().contains(v)) &&
     * !sisältääKaaren(u, v)
     * @.post OLD(this).equals(this.poistaKaari(u, v)) &
     * this.annaKaari(u, v).annaLeima().equals(leima)
     *
     * Ei Muokattu
     */
    public void lisääKaari(V u, V v, L leima)
    /** Poistaa kaaren.
     * @.pre sisältääKaaren(u, v)
     * @.post OLD(this).equals(this.lisääKaari(u, v,
     * OLD(this).annaKaari(u, v).annaLeima()))
     * && (!annaSolmut.contains(v) & !annaKaaret.contains(annaKaari(u, v)))
     *
     * Ei muokattu
     */
    public void poistaKaari(V u, V v)
//-- Arvosemanttiset operaatiot
    /** Tarkistaa graafien samuuden.
     * @.pre true
     * @.post RESULT ==
     * (sisältääkö graafi toinen samat solmut ja kaaret
     * kuin tämä graafi ja ovatko molemmat graafit joko
     * suunnattuja tai suuntaamattomia)
     *
     * Ei muokattu
     */
    public boolean equals(Object toinen)
} // class Graafi
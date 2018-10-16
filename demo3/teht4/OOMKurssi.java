import java.lang.*;
import java.util.*;

final class Maailma {
    private static long tuskanMäärä = 0;

    static void lisääTuskaa(int i) {
        tuskanMäärä += i;
        System.out.println("Tuskaa jo " + tuskanMäärä + " yksikköä!");
    }
}

// mallintaa opiskelijan nykyisen tilan OOM-kurssin osalta
final class OOMTilanne {
    boolean ilmoittautunut = false; // on ilmoittautunut joskus elämässään kurssille
    boolean hereillä = false; // hereillä juuri nyt
    boolean luennolla = false; // luennolla juuri nyt
}

interface Opiskelija {
    /**
     * @.pre true
     * @.post RESULT == (Palauttaa tilanneolion)
     */
    OOMTilanne annaOOMTilanne();

    /**
     * Asettaa opiskelijan nimen ja op. numeron
     *
     * @.pre nimi != null && opNumero>0
     * @.post (nimi & op.numero asetettu)
     **/
    void asetaNimiJaOpNumero(String nimi, int opNumero);

    /**
     * @.pre true
     * @.post annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä
     *        == false && annaOOMTilanne().luennolla == false &&
     *        (OLD(annaOOMTilanne().ilmoittautunut) || Maailma.tuskanMäärä ==
     *        OLD(Maailma.tuskanMäärä) + 1000)
     */
    void ilmoittauduOOMKurssille();

    /**
     * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
     *       false
     * @.post Maailma.tuskanMäärä == OLD(Maailma.tuskanMäärä) + 10 &&
     *        annaOOMTilanne().luennolla == true
     */
    void osallistuLuennolle();

    /**
     * @.pre 0 ≤ aikaaLuennonAlusta < 90
     * @.post annaOOMTilanne().hereillä == true
     */
    void herää(int aikaaLuennonAlusta);

    /**
     * @.pre annaOOMTilanne().luennolla == true
     * @.post annaOOMTilanne().luennolla == false && annaOOMTilanne().hereillä ==
     *        false
     */
    void poistuLuennolta();

    /**
     * @.pre annaOOMTilanne().ilmoittautunut == true && annaOOMTilanne().hereillä ==
     *       true
     * @.post Maailma.tuskanMäärä == OLD(tuskanMäärä) + 90 -
     *        hereilläAlkaenMinuutista && annaOOMTilanne().hereillä == true
     */
    void vastaaKysymykseen(int aikaaLuennonAlusta);
}

class TavallinenOpiskelija implements Opiskelija {

    protected String nimi;
    protected int opNumero;

    int hereilläAlkaenMinuutista = 0;

    public static OOMTilanne oomTilanne = new OOMTilanne();
    public static Maailma maailma = new Maailma();

    public TavallinenOpiskelija(String nimi, int opNumero) {
        this.nimi = nimi;
        this.opNumero = opNumero;
    }

    @Override
    public OOMTilanne annaOOMTilanne() {
        return oomTilanne;
    }

    @Override
    public void asetaNimiJaOpNumero(String nimi, int opNumero) {
        if (nimi == null && opNumero <= 0)
            return;

        this.nimi = nimi;
        this.opNumero = opNumero;

    }

    @Override
    public void ilmoittauduOOMKurssille() {
        oomTilanne.ilmoittautunut = true;
        oomTilanne.luennolla = false;
        oomTilanne.hereillä = false;

        maailma.lisääTuskaa(1000);
    }

    @Override
    public void osallistuLuennolle() {
        oomTilanne.luennolla = true;
        oomTilanne.ilmoittautunut = true;
        oomTilanne.hereillä = false;

        maailma.lisääTuskaa(10);
    }

    @Override
    public void herää(int aikaaLuennonAlusta) {
        if (aikaaLuennonAlusta >= 90 && aikaaLuennonAlusta < 0)
            return;

        oomTilanne.hereillä = true;

    }

    @Override
    public void poistuLuennolta() {
        if (oomTilanne.luennolla != true)
            return;

        oomTilanne.luennolla = false;
        oomTilanne.hereillä = false;
    }

    @Override
    public void vastaaKysymykseen(int aikaaLuennonAlusta) {
        if (oomTilanne.ilmoittautunut != true && oomTilanne.hereillä != true)
            return;

        maailma.lisääTuskaa(90 - aikaaLuennonAlusta);
    }
}

class ValeasuOpiskelija implements Opiskelija {

    protected String nimi;
    protected int opNumero;

    public static OOMTilanne oomTilanne = new OOMTilanne();
    public static Maailma maailma = new Maailma();

    private TavallinenOpiskelija opiskelija = new TavallinenOpiskelija(this.nimi, this.opNumero);

    @Override
    public OOMTilanne annaOOMTilanne() {
        return oomTilanne;
    }

    @Override
    public void asetaNimiJaOpNumero(String nimi, int opNumero) {
        if (nimi == null && opNumero <= 0)
            return;

        this.nimi = nimi;
        this.opNumero = opNumero;

    }

    @Override
    public void vastaaKysymykseen(int aikaaLuennonAlusta) {
        if (oomTilanne.hereillä == false)
            herää(aikaaLuennonAlusta);

        oomTilanne.hereillä = false;
    }

    @Override
    public void herää(int aikaaLuennonAlusta) {
        oomTilanne.hereillä = true;
        maailma.lisääTuskaa(1);
    }

    @Override
    public void ilmoittauduOOMKurssille() {
        oomTilanne.ilmoittautunut = true;
    }

    @Override
    public void osallistuLuennolle() {
        oomTilanne.luennolla = true;
    }

    @Override
    public void poistuLuennolta() {
        if (oomTilanne.luennolla != true)
            return;

        oomTilanne.luennolla = false;
        oomTilanne.hereillä = false;
    }

}

class OpiskelijaAllas {
    Object[] opiskelijat;



    public OpiskelijaAllas(int uhrimäärä) {
        opiskelijat = new Object[uhrimäärä];
    }

    public void lisääOpiskelija(Object opiskelija) {
        int topi = 0;
        for(Object o : opiskelijat) {
            if(!(o instanceof ValeasuOpiskelija) || !(o instanceof TavallinenOpiskelija)) {
                opiskelijat[topi] = opiskelija;
            } else {
                ((TavallinenOpiskelija)opiskelija).annaOOMTilanne().ilmoittautunut = false;
            }
            topi++;
        }
    }

    // Syvät pahoittelut t.Topi
    public Object haeOpiskelija() {

        int rn = new java.util.Random().nextInt(opiskelijat.length);

        Object[] tempArray = opiskelijat.clone();

        Object temp = tempArray[rn];
        opiskelijat[rn] = null;
        return temp;
    }

    public void printOpiskelijat(Object o) {

            System.out.println(((TavallinenOpiskelija)o).nimi + "  :  " + ((TavallinenOpiskelija)o).opNumero + "   :   " + ((TavallinenOpiskelija)o).annaOOMTilanne().ilmoittautunut);

    }
}


public class OOMKurssi {
    static Opiskelija[] hankiOpiskelijat(int uhriMäärä) {
        Opiskelija[] opiskelijat = new Opiskelija[uhriMäärä];
        for (int i = 0; i < uhriMäärä; i++)
            opiskelijat[i] = new TavallinenOpiskelija("Uniikki Lumihiutale", 1234567 + i);

        return opiskelijat;
    }

    // älä muuta tätä! muutoksien tulee kohdistua muualle! (kohdat b) ja d) siis)
    // tämä simuloi hienosti yhtä vuosi-instanssia myös kohtien b) ja d) tilanteissa
    final void pidäVuosittainenInstanssi(Opiskelija[] opiskelijat) {
        for (Opiskelija o : opiskelijat)
            o.ilmoittauduOOMKurssille();

        for (int luento = 0; luento < 8; luento++) {
            for (Opiskelija o : opiskelijat)
                o.osallistuLuennolle();

            opiskelijat[22].vastaaKysymykseen(30);
            opiskelijat[42].vastaaKysymykseen(60);
            opiskelijat[62].vastaaKysymykseen(75);

            for (Opiskelija o : opiskelijat)
                o.poistuLuennolta();
        }
    }

    Opiskelija[] Opiskelijat() {

        Opiskelija[] opiskelijat = new Opiskelija[3];

        opiskelijat[0] = new TavallinenOpiskelija("Uniikki Lumihiutale", 1234567 + 0);
        opiskelijat[1] = new TavallinenOpiskelija("Uniikki Lumihiutale", 1234567 + 1);
        opiskelijat[2] = new TavallinenOpiskelija("Uniikki Lumihiutale", 1234567 + 2);

        return opiskelijat;

    }

    public OOMKurssi() {
        OpiskelijaAllas allas = new OpiskelijaAllas(3);
        Opiskelija[] opiskelijat = Opiskelijat();

        for(Object o : opiskelijat) {
            allas.lisääOpiskelija(o);
            //allas.printOpiskelijat(o);
        }

        allas.haeOpiskelija();
        for(Object o : opiskelijat) {
            allas.printOpiskelijat(o);
        }


    }

    public static void main(String[] args) {
        int vuosi = 2018;
        //int uhriMäärä = 100 + new java.util.Random().nextInt(10 * (vuosi - 2000));  // Kommentoimme pois randomin ja testasimme,
                                                                                      // että tulos on järkevä
        //Opiskelija[] opiskelijat = hankiOpiskelijat(uhriMäärä);
        //new OOMKurssi().pidäVuosittainenInstanssi(opiskelijat);

        new OOMKurssi();
    }
}
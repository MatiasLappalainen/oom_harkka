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
    boolean luennolla = false; // luennolla juuri nyt}

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
         * @.post annaOOMTilanne().ilmoittautunut == true &&
         * annaOOMTilanne().hereillä == false &&
         * annaOOMTilanne().luennolla == false &&
         * (OLD(annaOOMTilanne().ilmoittautunut) ||
         * Maailma.tuskanMäärä == OLD(Maailma.tuskanMäärä) + 1000)
         */
        void ilmoittauduOOMKurssille();

        /**
         * @.pre annaOOMTilanne().ilmoittautunut == true &&
         * annaOOMTilanne().hereillä == false
         * @.post Maailma.tuskanMäärä == OLD(Maailma.tuskanMäärä) + 10 &&
         * annaOOMTilanne().luennolla == true
         */
        void osallistuLuennolle();

        /**
         * @.pre 0 ≤ aikaaLuennonAlusta < 90
         * @.post annaOOMTilanne().hereillä == true
         */
        void herää(int aikaaLuennonAlusta);

        /**
         * @.pre annaOOMTilanne().luennolla == true
         * @.post annaOOMTilanne().luennolla == false &&
         * annaOOMTilanne().hereillä == false
         */
        void poistuLuennolta();

        /**
         * @.pre annaOOMTilanne().ilmoittautunut == true &&
         * annaOOMTilanne().hereillä == true
         * @.post Maailma.tuskanMäärä == OLD(tuskanMäärä) + 90 - hereilläAlkaenMinuutista &&
         * annaOOMTilanne().hereillä == true
         */
        void vastaaKysymykseen(int aikaaLuennonAlusta);
    }

    class TavallinenOpiskelija implements Opiskelija {


    }

    class ValeasuOpiskelija implements Opiskelija { /* TODO */
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
            for (Opiskelija o : opiskelijat) o.ilmoittauduOOMKurssille();

            for (int luento = 0; luento < 8; luento++) {
                for (Opiskelija o : opiskelijat) o.osallistuLuennolle();

                opiskelijat[22].vastaaKysymykseen(30);
                opiskelijat[42].vastaaKysymykseen(60);
                opiskelijat[62].vastaaKysymykseen(75);

                for (Opiskelija o : opiskelijat) o.poistuLuennolta();
            }
        }

        public static void main(String[] args) {
            int vuosi = 2018;
            int uhriMäärä = 100 + new java.util.Random().nextInt(10 * (vuosi - 2000));
            Opiskelija[] opiskelijat = hankiOpiskelijat(uhriMäärä);
            new OOMKurssi().pidäVuosittainenInstanssi(opiskelijat);
        }
    }
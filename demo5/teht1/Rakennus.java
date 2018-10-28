package demot.demo5;

import fi.utu.oomkit.util.Color;
import fi.utu.oomkit.util.CoreColor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Rakennus {
    final int leveys;
    final int korkeus;
    final Color väri;
    final boolean[][] ikkunat;
    final long siemen;

    public Rakennus(int leveys, int korkeus, Color väri) {
        this(leveys, korkeus, väri, new Random().nextLong());
    }

    public Rakennus(int leveys, int korkeus, Color väri, long siemen) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.väri = väri;
        this.siemen = siemen;
        this.ikkunat = luoIkkunat(leveys, korkeus);
    }

    protected boolean[][] luoIkkunat(int leveys, int korkeus) {
        Random ikkunaMaatti = new Random(siemen);

        double väli = 12;
        int l = (int) (leveys / väli - 1 / 8.0);
        int k = (int) (korkeus / väli - 1 / 8.0);

        boolean[][] matriisi = new boolean[k][l];

        for (int x = 0; x < l; x++)
            for (int y = 0; y < k; y++)
                matriisi[y][x] = ikkunaMaatti.nextBoolean();

        return matriisi;
    }

    public Rakennus skaalaa(double kerroinX, double kerroinY) {
        double uusiLeveys = leveys * kerroinX;
        double uusiKorkeus = korkeus * kerroinY;
        return new Rakennus((int) uusiLeveys, (int) uusiKorkeus, väri, siemen);
    }

    static Rakennus luoSatunnainen(long siemen, int maxLeveys, int maxKorkeus) {
        Random jemma = new Random(siemen);

        Function<Integer, Integer> arvo = max -> jemma.nextInt(max * 4 / 5) + max / 5;
        int leveys = arvo.apply(maxLeveys);
        int korkeus = arvo.apply(maxKorkeus);

        return new Rakennus(
                leveys, korkeus,
                Arrays.asList(CoreColor.Cyan, CoreColor.Gray, CoreColor.Red).get(jemma.nextInt(3)),
                siemen
        );
    }

    public String toString() {
        return "Rakennus<" + siemen + ">";
    }
}
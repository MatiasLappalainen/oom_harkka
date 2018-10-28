package demot.demo5;

import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

public class GorillaLogic implements AppLogic {
    private final ArrayList<Rakennus> rakennukset = new ArrayList<>();

    private final GorillaPiirtopinta piirtoPinta = new GorillaPiirtopinta(rakennukset);

    public GorillaPiirtopinta piirtoPinta() {
        return piirtoPinta;
    }

    int i = 0;

    // alustaa pelin logiikan, päivitys 20ms välein
    @Override
    public AppConfiguration configuration() {
        return new AppConfiguration(20, "Demo", false);
    }

    /** you might want to reimplement this */
    @Override
    public void initialize() {
        for (int i = 0; i < new Random().nextInt(10) + 6; i++)
            lisääRakennus();
    }

    void lisääRakennus() {
        rakennukset.add(Rakennus.luoSatunnainen(new Random().nextLong(), 50, 100));
    }

    void sortRakennukset() {
        ArrayList<Rakennus> temp = new ArrayList<>();

        for (Rakennus r : rakennukset) {
            temp.add(rakennukset.indexOf(r), r);
        }

        rakennukset.sort(new Comparator<Rakennus>() {
            @Override
            public int compare(Rakennus yksi, Rakennus kaksi) {
                if (yksi.korkeus > kaksi.korkeus) {
                    return -1;
                } else if (yksi.korkeus < kaksi.korkeus) {
                    return 1;
                } else if (yksi.korkeus == kaksi.korkeus) {
                    if (yksi.leveys > kaksi.leveys) {
                        return -1;
                    } else if (yksi.leveys < kaksi.leveys) {
                        return 1;
                    }
                } else {
                    return 0;
                }
                return 0;
            }
        });
        System.out.println(rakennukset.equals(temp));

        if (rakennukset.equals(temp)) {
            Collections.shuffle(rakennukset);
        }

        piirtoPinta.redraw();
    }

    void sortLeveys() {
        rakennukset.sort(new Comparator<Rakennus>() {

            @Override
            public int compare(Rakennus yksi, Rakennus kaksi) {
                if (yksi.leveys > kaksi.leveys) {
                    return -1;
                } else if (yksi.leveys < kaksi.leveys) {
                    return 1;
                } else if (yksi.leveys == kaksi.leveys) {
                    if (yksi.korkeus > kaksi.korkeus) {
                        return -1;
                    } else if (yksi.korkeus < kaksi.korkeus) {
                        return 1;
                    }
                } else {
                    return 0;
                }
                return 0;
            }
        });

        piirtoPinta.redraw();
    }

    @Override
    public void tick() {
        i++;
        if (i > 50) {
            i = 0;
            lisääRakennus();
            rakennukset.remove(0);
        }
        piirtoPinta.redraw();
    }

}
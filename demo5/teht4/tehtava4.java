import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import demot.demo4.PiirtelyLogic;
import demot.demo4.PiirtelyPinta;
import fi.utu.oomkit.gui.*;
import fi.utu.oomkit.gui.OOMApp.SimpleMainWindow;

public class Tehtava4 extends OOMApp {

    public final static int X = 10;
    public final static int Y = 5;

    public static Object[][] hajautusTaulu;

    // alustaa pelilogiikan
    final static PiirtelyLogic appLogic = new PiirtelyLogic();

    public static void main(String[] args) {
        hajautusTaulu = generoiHajautusTaulu(10, 5);

        // luodaan hajautettavia oliota ja säilötään ne listaan käsittelyn helpottamiseksi
        List<HajautettavaOlio> lista = new ArrayList<HajautettavaOlio>();
        for (int i = 0; i < 50; i++) {
            HajautettavaOlio olio = new HajautettavaOlio();
            olio.sisältö = new String("Hajautettava Olio numero " + i);
            lista.add(olio);
        }

        for (HajautettavaOlio olio : lista) {
            System.out.println("Tallennetaan oliota hajautusarvolla " + olio.hajautusarvo);
            System.out.println("Onnistui: " + (tallenna(olio) ? "Kyllä" : "Ei"));
        }

        for (HajautettavaOlio olio : lista) {
            System.out.println("Etsitään oliota sisällöllä " + (String)olio.sisältö);
            System.out.println("Löytyikö: " + (tarkistaSisältäminen(olio) >= 0 ? "Kyllä" : "Ei" ));
        }

        for (HajautettavaOlio olio : lista) {
            System.out.println("Poistetaan oliota sisällöllä " + (String)olio.sisältö);
            System.out.println("Onnistuiko poisto: " + (poista(olio) ? "Kyllä" : "Ei"));
        }

    }

    // kytkee piirtopinnan kÃ¤yttÃ¶liittymÃ¤Ã¤n
    @Override
    protected MainWindow generateMainWindow(String appName, double width, double height) {
        return new SimpleMainWindow(appName, width, height) {
            @Override public OOMCanvas mainContent() {
                return appLogic.piirtoPinta();
            }
        };
    }

    /*
     *
     */
    public static boolean tallenna(HajautettavaOlio olio) {
        for (int i = 0; i < Y; i++) {
            if (hajautusTaulu[olio.hajautusarvo][i] != null) {
                continue;
            }
            hajautusTaulu[olio.hajautusarvo][i] = olio;
            return true;
        }
        return false;
    }

    public static int tarkistaSisältäminen(HajautettavaOlio olio) {
        for (int i = 0; i < Y; i++) {
            if (hajautusTaulu[olio.hajautusarvo][i] == olio) {
                return i;
            }
        }
        return -1;
    }

    public static boolean poista(HajautettavaOlio olio) {
        int lokeronIndeksi = tarkistaSisältäminen(olio);
        if (lokeronIndeksi == -1) {
            return false;
        } else {
            hajautusTaulu[olio.hajautusarvo][lokeronIndeksi] = null;

            if (lokeronIndeksi < Y - 1) {
                HajautettavaOlio väliaikainen = (HajautettavaOlio)hajautusTaulu[olio.hajautusarvo][Tehtava4.Y - 1];
                hajautusTaulu[olio.hajautusarvo][lokeronIndeksi] = väliaikainen;
                hajautusTaulu[olio.hajautusarvo][Tehtava4.Y - 1] = null;
            }

            return true;
        }
    }

    /*
     *
     */
    public static Object[][] generoiHajautusTaulu(int x, int y) {
        return new Object[x][y];
    }
}

class HajautettavaOlio {
    public int hajautusarvo;
    public Object sisältö;

    public HajautettavaOlio() {
        Random rand = new Random();

        // generoidaan hajautettavalle oliolle joku hajautusarvo Tehtava4-luokan
        // maksimiarvoa (X) käyttäen
        this.hajautusarvo = rand.nextInt(Tehtava4.X);
    }
}
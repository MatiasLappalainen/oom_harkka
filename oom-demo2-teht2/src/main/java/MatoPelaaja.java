import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.gui.MainWindow;
import fi.utu.oomkit.gui.OOMApp;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class MatoPelaaja {

    int pituus = 5;
    int pistesumma = 0;
    String nimi;
    Color vari;

    public MatoPelaaja(String nimi, Color vari) {
        this.nimi = nimi;
        this.vari = vari;
    }

    public void addToPisteSumma() {
        pistesumma += 1;
        pituus += 1;
    }

    public String getNimi() {
        return nimi;
    }

    public Color getVari() {
        return vari;
    }

    public int getPituus() {
        return pituus;
    }

}
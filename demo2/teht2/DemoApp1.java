import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.gui.MainWindow;
import fi.utu.oomkit.gui.OOMApp;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.Point;
import javafx.scene.canvas.GraphicsContext;

/**
 * LaatikkoPiirtopinta. Käyttöliittymä huolehtii teknisestä toteutuksesta.
 * @see this.redraw() Piirrä uudestaan, riittää kutsua vain kun sisältö muuttuu.
 * @see this.drawForegroundContent(canvas) piirtää "edustan"
 * @see this.drawBackgroundContent(canvas) piirtää "taustan", oletus: täysin valkoinen
 */
class LaatikkoPiirtopinta extends SimpleCanvas {
    private final int koko = 12;
    private Point piste;

    LaatikkoPiirtopinta() { super(true); }

    // asettaa piirrettävän pisteen
    void asetaPiste(Point piste) {
        this.piste = piste;
    }

    // piirtää pisteen p size-kokoisena neliönä, vas. yläreuna = p
    private void drawRectangle(GraphicsContext canvas, Point p, int size) {
        canvas.setFill(javafx.scene.paint.Color.DARKBLUE);
        canvas.fillRect(p.x, p.y, size, size);
    }

    // piirrä piste, jos koordinaatti olemassa (piste != null)
    protected void drawForegroundContent(GraphicsContext canvas) {
        if (piste != null) drawRectangle(canvas, piste, koko);
    }
}

class LaatikkoGameLogic implements AppLogic {
    final LaatikkoPiirtopinta piirtoPinta = new LaatikkoPiirtopinta();
    private final int reuna = 25;

    private int liikkeenTila = 0;
    private Point piste = new Point(reuna, reuna);

    // alustaa pelin logiikan, päivitys 20ms välein
    @Override
    public AppConfiguration configuration() {
        return new AppConfiguration(20, "Demo", false);
    }

    @Override
    public void tick() {
        double max_x = piirtoPinta.getWidth() - reuna;
        double max_y = piirtoPinta.getHeight() - reuna;
        switch (liikkeenTila) {
            case 0:
                if (piste.x < max_x)
                    piste = piste.add(5, 0);
                else liikkeenTila = 1;
                break;
            case 1:
                if (piste.y < max_y)
                    piste = piste.add(0, 5);
                else liikkeenTila = 2;
                break;
            case 2:
                if (piste.x > reuna)
                    piste = piste.add(-5, 0);
                else liikkeenTila = 3;
                break;
            case 3:
                if (piste.y > reuna)
                    piste = piste.add(0, -5);
                else liikkeenTila = 0;
                break;
        }
        piirtoPinta.asetaPiste(piste);
        piirtoPinta.redraw();
    }

}

public class DemoApp1 extends OOMApp {
    // alustaa pelilogiikan
    final static LaatikkoGameLogic gameLogic = new LaatikkoGameLogic();

    // kytkee piirtopinnan käyttöliittymään
    @Override
    protected MainWindow generateMainWindow(String appName, double width, double height) {
        return new SimpleMainWindow(appName, width, height) {
            @Override public SimpleCanvas mainContent() {
                return gameLogic.piirtoPinta;
            }
        };
    }

    // alustaa demo-ohjelman (käyttöliittymä)
    public DemoApp1() {
        super(gameLogic);
    }

    // alustaa demo-ohjelman (JavaFX)
    public static void main(String[] args) {
        launch(args);
    }
}
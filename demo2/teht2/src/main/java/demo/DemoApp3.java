import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.gui.MainWindow;
import fi.utu.oomkit.gui.OOMApp;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.KeyHandler;
import fi.utu.oomkit.util.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * LaatikkoPiirtopinta. Käyttöliittymä huolehtii teknisestä toteutuksesta.
 * @see this.redraw() Piirrä uudestaan, riittää kutsua vain kun sisältö muuttuu.
 * @see this.drawForegroundContent(canvas) piirtää "edustan"
 * @see this.drawBackgroundContent(canvas) piirtää "taustan", oletus: täysin valkoinen
 */
class LaatikkoPiirtopinta2 extends SimpleCanvas {
    private final int koko = 12;
    private Point piste;
    private boolean piilotus = true;

    LaatikkoPiirtopinta2() { super(true); }

    // asettaa piirrettävän pisteen
    void asetaPiste(Point piste) {
        this.piste = piste;
    }

    // asettaa piirtopinnan näkyviin
    void asetaPiilotus(boolean piilotus) {
        this.piilotus = piilotus;
    }


    // piirtää pisteen p size-kokoisena neliönä, vas. yläreuna = p
    private void drawRectangle(GraphicsContext canvas, Point p, int size) {
        canvas.setFill(javafx.scene.paint.Color.DARKBLUE);
        canvas.fillRect(p.x, p.y, size, size);
    }

    // piilota näkymä, jos piilotus päällä
    protected void drawForegroundContent(GraphicsContext canvas) {
        canvas.setFill(Color.BLACK);
        if (piilotus)
            canvas.fillRect(0, 0, getWidth(), getHeight());
    }

    // piirrä piste, jos koordinaatti olemassa (piste != null)
    protected void drawBackgroundContent(GraphicsContext canvas) {
        super.drawBackgroundContent(canvas);
        if (piste != null) drawRectangle(canvas, piste, koko);
    }
}

class LaatikkoGameLogic2 implements AppLogic {
    final LaatikkoPiirtopinta2 piirtoPinta = new LaatikkoPiirtopinta2();
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
        // piilottaa jaksottain näkymän
        // varoitus: seuraavan rivin säätö voi olla vaarallinen epileptikolle
        piirtoPinta.asetaPiilotus(((piste.x+piste.y)/5)%150<75);

        piirtoPinta.asetaPiste(piste);
        piirtoPinta.redraw();
    }

    // käsittele näppäimen painallus
    @Override
    public void handleKey(Key k) {
        System.out.println(k);
    }
}

public class DemoApp3 extends OOMApp {
    // alustaa pelilogiikan
    final static LaatikkoGameLogic2 gameLogic = new LaatikkoGameLogic2();

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
    public DemoApp3() {
        super(gameLogic);
    }

    // alustaa demo-ohjelman (JavaFX)
    public static void main(String[] args) {
        launch(args);
    }
}
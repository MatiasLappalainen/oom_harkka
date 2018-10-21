import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.gui.MainWindow;
import fi.utu.oomkit.gui.OOMApp;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.Point;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 * TekstiPiirtopinta. Käyttöliittymä huolehtii teknisestä toteutuksesta.
 * @see this.redraw() Piirrä uudestaan, riittää kutsua vain kun sisältö muuttuu.
 * @see this.drawForegroundContent(canvas) piirtää "edustan"
 * @see this.drawBackgroundContent(canvas) piirtää "taustan", oletus: täysin valkoinen
 */
class TekstiPiirtopinta extends SimpleCanvas {
    private final int koko = 24;
    private Point piste;
    private char kirjain;
    private boolean piirto = true;

    TekstiPiirtopinta() { super(true);
    }

    // asettaa piirron paikan
    void asetaPiste(Point piste) {
        this.piste = piste;
    }

    // asettaa piirrettävän kirjaimen
    void asetaKirjain(char kirjain) {
        this.kirjain = kirjain;
    }

    // asettaa piirron/kumituksen
    void asetaPiirto(boolean piirto) {
        this.piirto = piirto;
    }

    // piirtää kirjaimen l, size-kokoisena, kirjaimen vas. yläreuna = p
    private void drawText(GraphicsContext canvas, Point p, char l, int size) {
        if (piirto) {
            canvas.setStroke(Color.DARKBLUE);
            canvas.setTextBaseline(VPos.BOTTOM);
            canvas.setTextAlign(TextAlignment.CENTER);
            canvas.setFont(Font.font("Courier New", FontWeight.BOLD, size));
            canvas.strokeText(""+l,p.x, p.y);
        } else
            canvas.clearRect(p.x-size/2, p.y-size+1, size, size);

    }

    // piirrä piste, jos koordinaatti olemassa (piste != null)
    protected void drawForegroundContent(GraphicsContext canvas) {
        if (piste != null) drawText(canvas, piste, kirjain, koko);
    }

    // ei pyyhitä taustalla pois vanhoja
    protected void drawBackgroundContent(GraphicsContext canvas) {
        // ei toiminnallisuutta
    }
}

class TekstiGameLogic implements AppLogic {
    final TekstiPiirtopinta piirtoPinta = new TekstiPiirtopinta();
    private final int reuna = 25;

    private int i = 0;
    private Point alkuPiste = new Point(reuna*2, reuna*2);

    // alustaa pelin logiikan, päivitys 25ms välein
    @Override
    public AppConfiguration configuration() {
        return new AppConfiguration(25, "Demo", false);
    }

    @Override
    public void tick() {
        if (i>21) { i=0; }

        piirtoPinta.asetaPiirto(i<11);
        piirtoPinta.asetaPiste(alkuPiste.add(i%11*20,0));
        piirtoPinta.asetaKirjain("Hello world!".charAt(i%11));
        piirtoPinta.redraw();
        i++;
    }

}

public class DemoApp2 extends OOMApp {
    // alustaa pelilogiikan
    final static TekstiGameLogic gameLogic = new TekstiGameLogic();

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
    public DemoApp2() {
        super(gameLogic);
    }

    // alustaa demo-ohjelman (JavaFX)
    public static void main(String[] args) {
        launch(args);
    }
}
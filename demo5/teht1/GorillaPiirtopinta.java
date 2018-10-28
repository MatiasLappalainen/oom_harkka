package demot.demo5;

import demot.demo4.PiirtelyPinta;
import fi.utu.oomkit.util.CoreColor;
import fi.utu.oomkit.util.Point;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.List;

/**
 * PiirtelyPinta. Käyttöliittymä huolehtii teknisestä toteutuksesta.
 * 
 * @see this.redraw() Piirrä uudestaan, riittää kutsua vain kun sisältö muuttuu.
 * @see this.drawForegroundContent(GraphicsContext) piirtää "edustan"
 * @see this.drawBackgroundContent(GraphicsContext) piirtää "taustan", oletus:
 *      täysin valkoinen
 */
public class GorillaPiirtopinta extends PiirtelyPinta {
    private final List<Rakennus> rakennukset;
    Image image = new Image("http://users.utu.fi/jmjmak/troll2.png");

    public GorillaPiirtopinta(List<Rakennus> rakennukset) {
        this.rakennukset = rakennukset;
        debuggaus = false;
    }

    void piirräRakennus(Point paikka, Rakennus rakennus, GraphicsContext canvas) {
        Point ylä = paikka.sub(0, rakennus.korkeus);
        piirräLaatikko(ylä, paikka.add(rakennus.leveys, 0), rakennus.väri, true, canvas);

        int väli = 12;
        int y = väli / 2;
        for (boolean[] rivi : rakennus.ikkunat) {
            int x = väli / 2;
            for (boolean ikkuna : rivi) {
                piirräLaatikko(ylä.add(x, y), ylä.add(x + väli / 2, y + väli / 2),
                        ikkuna ? CoreColor.DimGray : CoreColor.Yellow, true, canvas);
                x += väli;
            }
            y += väli;
        }
    }

    // piirtää kirjaimen l, size-kokoisena, kirjaimen vas. yläreuna = p
    private void kirjoita(Point p, String s, int size, GraphicsContext canvas) {
        Font font = Font.font("Courier New", FontWeight.BOLD, size);
        Point diff = new Point(s.length() * size / 2, size / 2);
        piirräLaatikko(p.sub(diff), p.add(diff), CoreColor.Black, true, canvas);
        setFill(CoreColor.White);
        canvas.setTextBaseline(VPos.CENTER);
        canvas.setTextAlign(TextAlignment.CENTER);
        canvas.setFont(font);
        canvas.fillText(s, p.x, p.y);
    }

    protected void drawBackgroundContent(GraphicsContext canvas) {
        setFill(CoreColor.Blue);
        canvas.fillRect(0, 0, getWidth(), getHeight());
    }

    protected void drawForegroundContent(GraphicsContext canvas) {
        int näyttöKorkeus = (int) getHeight(), näyttöLeveys = (int) getWidth();

        // aurinko
        {
            Point keski = new Point(näyttöLeveys / 2, näyttöKorkeus / 12);
            piirräPallukka(keski, CoreColor.Yellow, näyttöLeveys / 21, true, canvas);
            for (int i = 0; i < 15; i++) {
                double kulma = Math.PI * 2 * i / 15;
                piirräViiva(kaarelta(keski, kulma, näyttöLeveys / 22), kaarelta(keski, kulma, näyttöLeveys / 16),
                        CoreColor.Yellow, canvas

                );
                canvas.drawImage(image, keski.x - näyttöLeveys / 24 / 2, keski.y - näyttöLeveys / 24 / 2,
                        näyttöLeveys / 24, näyttöLeveys / 24);
            }
        }
        // rakennukset
        {
            double rakLeveys = rakennukset.stream().mapToInt(r -> r.leveys).sum(),
                    rakKorkeus = rakennukset.stream().mapToInt(r -> r.korkeus).max().orElseGet(() -> 1);

            if (näyttöKorkeus == 0 || näyttöLeveys == 0)
                return;

            double suhdeKorkeus = näyttöKorkeus * 3.0 / 4.0 / rakKorkeus, suhdeLeveys = näyttöLeveys / rakLeveys;

            Point paikka = new Point(0, (int) näyttöKorkeus);

            for (Rakennus r : rakennukset) {
                Rakennus skaalattu = r.skaalaa(suhdeLeveys, suhdeKorkeus);
                piirräRakennus(paikka, skaalattu, canvas);
                kirjoita(paikka.add(skaalattu.leveys / 2, -32), Integer.toString(rakennukset.indexOf(r) + 1), 24,
                        canvas);
                paikka = paikka.add(skaalattu.leveys, 0);
            }
        }
    }
}
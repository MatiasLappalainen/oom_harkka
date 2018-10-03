import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

class MatoNakyma extends SimpleCanvas {

    Point[] Mato = new Point[5];

    MatoPelaaja pelaaja = new MatoPelaaja("Topi", Color.AQUA);

    Point paa;
    Point hanta;
    final int koko = 10;

    int suunta = 0;

    public MatoNakyma(Point hanta) {
        super(true);

        this.hanta = hanta;
        maaritaPisteet();
    }

    void asetaPiste(Point piste) {
        this.hanta = piste;
    }

    private void maaritaPisteet() {
        int pituus = pelaaja.getPituus();

        for (int i = 0; i < pituus; i++) {
            Mato[i] = new Point(hanta.x + (koko*i), hanta.y);
        }
    }

    public Point[] getMato() {
        return Mato;
    }


    private void drawRectangle(GraphicsContext canvas, Point p, int size) {
        canvas.setFill(javafx.scene.paint.Color.DARKBLUE);
        canvas.fillRect(p.x, p.y, size, size);
    }

    // piirrä piste, jos koordinaatti olemassa (piste != null)
    protected void drawForegroundContent(GraphicsContext canvas) {
        for (int i = 0; i < Mato.length; i++) {
            drawRectangle(canvas, Mato[i], koko);
        }
    }
}
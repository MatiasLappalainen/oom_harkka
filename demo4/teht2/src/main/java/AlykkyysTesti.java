import javafx.scene.canvas.GraphicsContext;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.Point;
import fi.utu.oomkit.util.CoreColor;
import fi.utu.oomkit.util.Color;
import java.util.Random;



class AlykkyysTesti extends SimpleCanvas {

    public AlykkyysTesti() {
        super(true);
    }

    void drawRectangle(Point p, Color color, boolean filled, double size, GraphicsContext canvas) {
        if (filled) {
            setFill(color);
            canvas.fillRect(p.x-size/2, p.y-size/2, size, size);
        } else {
            canvas.setLineWidth(2);
            setStroke(color);
            canvas.strokeRect(p.x-size/2, p.y-size/2, size, size);
        }
    }

    void drawTriangle(Point p, Color color, boolean filled, double size, GraphicsContext canvas) {
        Point point1 = kaarelta(p, Math.PI * 1 / 6, size / 2 / 37 * 50);
        Point point2 = kaarelta(p, Math.PI * 5 / 6, size / 2 / 37 * 50);
        Point point3 = kaarelta(p, Math.PI * 9 / 6, size / 2 / 37 * 50);

        int siirtymäY = p.y - (point2.y + point3.y) / 2;
        point1 = point1.add(0, siirtymäY);
        point2 = point2.add(0, siirtymäY);
        point3 = point3.add(0, siirtymäY);

        if (filled) {
            setFill(color);
            canvas.fillPolygon(new double[] { point1.x, point2.x, point3.x }, new double[] { point1.y, point2.y, point3.y }, 3);
        } else {
            setStroke(color);
            canvas.strokePolygon(new double[] { point1.x, point2.x, point3.x }, new double[] { point1.y, point2.y, point3.y }, 3);
        };


    }

    void piirräPallukka(Point p, Color väri, boolean täytetty, double koko, GraphicsContext canvas) {
        if (täytetty) {
            setFill(väri);
            canvas.fillOval(p.x - koko / 2, p.y - koko / 2, koko, koko);
        } else {
            canvas.setLineWidth(2);
            setStroke(väri);
            canvas.strokeOval(p.x - koko / 2, p.y - koko / 2, koko, koko);
        }
    }
    void NeliönKolmio(Point p, Color väri, boolean täytetty, double koko, GraphicsContext canvas) {
           
    }



        static Point kaarelta(Point keski, double kaariKulma, double säde) {
        return keski.add((int) (säde * Math.cos(kaariKulma)), (int) (säde * Math.sin(kaariKulma)));
    }

    protected String generateRandomShape() {
        String[] shapes = {"rectangle", "triangle", "circle"};

        return shapes[(new Random()).nextInt(shapes.length)];
    }

    private void generateShape(String shape, Point p, Color color, boolean filled, double size, GraphicsContext canvas) {
        if(shape == "rectangle") drawRectangle(p, color, filled, size, canvas);
        else if(shape == "triangle") drawTriangle(p, color, filled, size, canvas);
        else if(shape == "circle") piirräPallukka(p, color, filled, size, canvas);
    }

    protected void drawForegroundContent(GraphicsContext canvas) {
        int row = 100;
        int col = 100;
        Point[] points = new Point[9];
        int rowI = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 3*i; j < (i+1)*3; j++) {
                points[j] = new Point(row*(i+1), col*(1+(j+1)%3));
            }
        }


        for(int x = 0; x < points.length; x++) {
            generateShape(generateRandomShape(), points[x], CoreColor.generateRandomColor(), false, 50D, canvas);
            generateShape(generateRandomShape(), points[x], CoreColor.generateRandomColor(), true, 50D/3, canvas);
        }
    }


    }
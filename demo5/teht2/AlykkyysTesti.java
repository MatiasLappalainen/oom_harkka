import javafx.scene.canvas.GraphicsContext;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.Point;
import fi.utu.oomkit.util.CoreColor;
import fi.utu.oomkit.util.Color;
import java.util.Random;

class AlykkyysTesti {

    protected void drawForegroundContent(GraphicsContext canvas) {
        int row = 100;
        int col = 100;
        Point[] points = new Point[9];
        int rowI = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 3 * i; j < (i + 1) * 3; j++) {
                points[j] = new Point(row * (i + 1), col * (1 + (j + 1) % 3));
            }
        }

        for (int x = 0; x < points.length; x++) {
            generateShape(generateRandomShape(), points[x], CoreColor.generateRandomColor(), false, 50D, canvas);
            generateShape(generateRandomShape(), points[x], CoreColor.generateRandomColor(), true, 50D / 3, canvas);
        }
    }
}

    

    

    

    

     

    

    

    

   

    

    

    

    


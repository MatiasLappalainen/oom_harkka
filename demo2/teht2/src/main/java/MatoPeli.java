import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.gui.MainWindow;
import fi.utu.oomkit.gui.OOMApp;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.util.Point;
import javafx.scene.canvas.GraphicsContext;

import static javafx.application.Application.launch;

public class MatoPeli extends OOMApp{
    // alustaa pelilogiikan
    final static PeliLogiikka gameLogic = new PeliLogiikka();

    // kytkee piirtopinnan käyttöliittymään
    @Override
    protected MainWindow generateMainWindow(String appName, double width, double height) {
        return new SimpleMainWindow(appName, width, height) {
            @Override
            public SimpleCanvas mainContent() {
                return gameLogic.piirtoPinta;
            }
        };
    }

    // alustaa demo-ohjelman (käyttöliittymä)
    public MatoPeli() {
        super(gameLogic);
    }

    // alustaa demo-ohjelman (JavaFX)
    public static void main(String[] args) {
        launch(args);
    }
}
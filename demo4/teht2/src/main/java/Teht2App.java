import fi.utu.oomkit.gui.MainWindow;
import fi.utu.oomkit.gui.OOMApp;
import fi.utu.oomkit.gui.SimpleCanvas;
import fi.utu.oomkit.*;

public class Teht2App extends OOMApp {
    // alustaa pelilogiikan
    final static AlykkyysLogic appLogic = new AlykkyysLogic();

    // kytkee piirtopinnan käyttöliittymään
    @Override
    protected MainWindow generateMainWindow(String appName, double width, double height) {
        return new SimpleMainWindow(appName, width, height) {
            @Override
            public SimpleCanvas mainContent() {
                return appLogic.alykkyys();
            }
        };
    }

    // alustaa demo-ohjelman (käyttöliittymä)
    public Teht2App() {
        super(appLogic);
    }
}
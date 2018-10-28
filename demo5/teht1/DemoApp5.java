package demot.demo5;

import fi.utu.oomkit.gui.MainWindow;
import fi.utu.oomkit.gui.OOMApp;
import fi.utu.oomkit.gui.SimpleCanvas;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;

public class DemoApp5 extends OOMApp {
    // alustaa pelilogiikan
    final static GorillaLogic appLogic = new GorillaLogic();

    // kytkee piirtopinnan käyttöliittymään
    @Override
    protected MainWindow generateMainWindow(String appName, double width, double height) {
        return new SimpleMainWindow(appName, width, height) {
            @Override
            public SimpleCanvas mainContent() {
                return appLogic.piirtoPinta();
            }

            // tässä kannattaa käskyttää ohjelman logiikkaluokkaa
            @Override
            public List<Node> bottomBarContent() {
                return Arrays.asList(new Button("Järjestys #1") {
                    {
                        setOnAction(e -> appLogic.sortRakennukset());
                    }
                }, new Button("Järjestys #2") {
                    {
                        setOnAction(e -> appLogic.sortLeveys());
                    }
                }, new Button("Lajittelu") {
                    {
                        setOnAction(e -> appLogic.sortRakennukset());
                    }
                }, new Button("Exit") {
                    {
                        setOnAction(e -> System.exit(0));
                    }
                });
            }
        };
    }

    // alustaa demo-ohjelman (käyttöliittymä)
    public DemoApp5() {
        super(appLogic);
    }
}

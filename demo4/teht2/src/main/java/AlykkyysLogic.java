import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.*;

public class AlykkyysLogic implements AppLogic {
    private final AlykkyysTesti alykkyys = new AlykkyysTesti();

    public AlykkyysTesti alykkyys() {
        return alykkyys;
    }

    // alustaa pelin logiikan, päivitys 20ms välein
    @Override
    public AppConfiguration configuration() {
        return new AppConfiguration(20, "Demo", false);
    }

    @Override
    public void tick() {
        alykkyys.redraw();
    }

}
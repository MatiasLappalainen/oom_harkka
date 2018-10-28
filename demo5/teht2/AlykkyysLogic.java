import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.*;

public class AlykkyysLogic implements AppLogic {
    private final AlykkyysTesti alykkyys = new AlykkyysTesti();

    public AlykkyysTesti alykkyys() {
        return alykkyys;
    }

    void compareKuviot() {
        ArrayList<Kuvio> kuviot = new ArrayList<>();

        kuviot.add(new Neliö());
        kuviot.add(new Kolmio());
        kuviot.add(new Ympyrä());

        kuviot.get(0).compare()
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
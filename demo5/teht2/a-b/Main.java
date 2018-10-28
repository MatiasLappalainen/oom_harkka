import java.util.ArrayList;

public class Main {

    public Main() {
        ArrayList<Kuvio> kuviot = new ArrayList<>();

        kuviot.add(new Neliö());
        kuviot.add(new Kolmio());
        kuviot.add(new Ympyrä());

        System.out.println(kuviot.get(0).compare(kuviot.get(1)));
    }

    public static void main(String[] args) {
        new Main();
    }
}
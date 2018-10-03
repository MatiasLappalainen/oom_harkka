import fi.utu.oomkit.AppConfiguration;
import fi.utu.oomkit.AppLogic;
import fi.utu.oomkit.util.Point;



class PeliLogiikka implements AppLogic {

    Point piste = new Point(100, 100);

    final MatoNakyma piirtoPinta = new MatoNakyma(piste);


    private final int reuna = 20;

    /**
     * Jokaisella madon palikalla on oma liikkeentila,
     * Jatkokehityksellisesti tämä voisi olla mato luokassa
     */
    private int[] liikkeenTila = new int[5];


    // alustaa pelin logiikan, päivitys 100ms välein
    @Override
    public AppConfiguration configuration() {
        return new AppConfiguration(20, "Demo", false);
    }

    @Override
    public void tick() {
        double max_x = piirtoPinta.getWidth() - reuna;
        double max_y = piirtoPinta.getHeight() - reuna;

        Point[] pisteet = piirtoPinta.getMato();

        for (int i = 0; i < pisteet.length; i++) {

            switch (liikkeenTila[i]) {
                case 0:
                    if (pisteet[i].x < max_x)
                        pisteet[i] = pisteet[i].add(10, 0);
                    else
                        liikkeenTila[i] = 1;
                    break;
                case 1:
                    if (pisteet[i].y < max_y)
                        pisteet[i] = pisteet[i].add(0, 10);
                    else
                        liikkeenTila[i] = 2;
                    break;
                case 2:
                    if (pisteet[i].x > reuna)
                        pisteet[i] = pisteet[i].add(-10, 0);
                    else
                        liikkeenTila[i] = 3;
                    break;
                case 3:
                    if (pisteet[i].y > reuna)
                        pisteet[i] = pisteet[i].add(0, -10);
                    else
                        liikkeenTila[i] = 0;
                    break;
            }
            piirtoPinta.asetaPiste(piste);

        }



        piirtoPinta.redraw();
    }

}
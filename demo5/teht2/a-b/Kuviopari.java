class Kuviopari extends Kuvio {

    Kuvio ulko;
    Kuvio sisä;

    public Kuviopari(Kuvio ulko, Kuvio sisä) {
        this.ulko = ulko;
        this.sisä = sisä;
    }

    @Override
    public int getKulma() {
        return ulko.getKulma() + sisä.getKulma();
    }

    /*
     * @Override void draw(Point p, Color color, boolean filled, double size,
     * GraphicsContext canvas) { this.ulko.draw(p, color, filled, size, canvas);
     * this.sisä.draw(p, color, filled, size, canvas); }
     */
}
class Ympyrä extends Kuvio {
    private final int kulmat = 100000;

    @Override
    void draw(Point p, Color väri, boolean täytetty, double koko, GraphicsContext canvas) {
        if (täytetty) {
            setFill(väri);
            canvas.fillOval(p.x - koko / 2, p.y - koko / 2, koko, koko);
        } else {
            canvas.setLineWidth(2);
            setStroke(väri);
            canvas.strokeOval(p.x - koko / 2, p.y - koko / 2, koko, koko);
        }
    }
    public int getKulmat(){
        return kulmat;
    }
}
class Neliö extends Kuvio {

    private final int kulmat = 4;

    @Override
    void draw(Point p, Color color, boolean filled, double size, GraphicsContext canvas) {
        if (filled) {
            setFill(color);
            canvas.fillRect(p.x - size / 2, p.y - size / 2, size, size);
        } else {
            canvas.setLineWidth(2);
            setStroke(color);
            canvas.strokeRect(p.x - size / 2, p.y - size / 2, size, size);
        }
    }

    public int getKulmat(){
        return kulmat;
    }
}
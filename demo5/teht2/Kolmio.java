class Kolmio extends Kuvio {
    private final int kulmat = 3;

    @Override
    public void draw(Point p, Color color, boolean filled, double size, GraphicsContext canvas) {
        Point point1 = kaarelta(p, Math.PI * 1 / 6, size / 2 / 37 * 50);
        Point point2 = kaarelta(p, Math.PI * 5 / 6, size / 2 / 37 * 50);
        Point point3 = kaarelta(p, Math.PI * 9 / 6, size / 2 / 37 * 50);

        int siirtymäY = p.y - (point2.y + point3.y) / 2;
        point1 = point1.add(0, siirtymäY);
        point2 = point2.add(0, siirtymäY);
        point3 = point3.add(0, siirtymäY);

        if (filled) {
            setFill(color);
            canvas.fillPolygon(new double[] { point1.x, point2.x, point3.x },
                    new double[] { point1.y, point2.y, point3.y }, 3);
        } else {
            setStroke(color);
            canvas.strokePolygon(new double[] { point1.x, point2.x, point3.x },
                    new double[] { point1.y, point2.y, point3.y }, 3);
        }
        ;
    }

    static Point kaarelta(Point keski, double kaariKulma, double säde) {
        return keski.add((int) (säde * Math.cos(kaariKulma)), (int) (säde * Math.sin(kaariKulma)));
    }

    public int getKulmat(){
        return kulmat;
    }
}
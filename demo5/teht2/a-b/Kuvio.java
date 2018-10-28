class Kuvio {

    private int kulmat;

    void draw() {
    }

    public String compare(Kuvio vertailtava) {
        System.out.println(this.getKulma() + "  :  " + vertailtava.getKulma());
        if (this.getKulma() == vertailtava.getKulma()) {
            /*
             * this.draw(); vertailtava.draw();
             */
            return "equal";
        } else if (this.getKulma() > vertailtava.getKulma()) {
            /*
             * this.draw(); vertailtava.draw();
             */
            return "higher";
        }

        return "unknown";
    }

    protected void setKulmat(int kulmat) {
        this.kulmat = kulmat;
    }

    public int getKulma() {
        return this.kulmat;
    }
}
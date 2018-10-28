class Kuvio {

    private int kulmat;

    void draw() {
    }

    public void compare(Kuvio vertailtava) {
        if(this.getKulma() == vertailtava.getKulma()) {
            this.draw();
            vertailtava.draw();
        } else if(this.getKulma() > vertailtava.getKulma()){
            this.draw();
            vertailtava.draw();
        }
    }

    public int getKulma() {
        return this.kulmat;
    }
}
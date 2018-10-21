class Laji {
    String nimi;
    String domeeni;
    String kunta;
    String pääjakso;
    String alajakso;
    String luokka;
    String lahko;
    String heimo;
    String alaheimo;
    String suku;
    String laji;

    public Laji(String domeeni, String kunta, String pääjakso, String alajakso, String luokka, String lahko, String heimo, String alaheimo, String suku, String laji) {
        this.nimi = nimi;
        this.domeeni = domeeni;
        this.kunta = kunta;
        this.pääjakso = pääjakso;
        this.alajakso = alajakso;
        this.luokka = luokka;
        this.lahko = lahko;
        this.heimo = heimo;
        this.alaheimo = alaheimo;
        this.suku = suku;
        this.laji = laji;
    }

    public Laji[] yhdistä(Laji toinen) {
        Laji[] tempArray = {this, toinen};
        return tempArray;
    }

    public Laji[] yhdistä(Laji[] toinen) {
        Laji[] tempArray = {this, toinen[0], toinen[1]};
        return tempArray;
    }


    public void displayData(Laji[] lajit) {
        System.out.println(
                        "Domeeni: " + lajit[0].domeeni + "   " + lajit[1].domeeni + "\n" +
                        "Kunta: " + lajit[0].kunta + "   " + lajit[1].kunta + "\n" +
                        "Pääjakso: " + lajit[0].pääjakso + "   " + lajit[1].pääjakso + "\n" +
                        "Alajakso: " + lajit[0].alajakso + "   " + lajit[1].alajakso + "\n" +
                        "Luokka: " + lajit[0].luokka + "   " + lajit[1].luokka + "\n" +
                        "Lahko: " + lajit[0].lahko + "   " + lajit[1].lahko + "\n" +
                        "Heimo: " + lajit[0].heimo + "   " + lajit[1].heimo + "\n" +
                        "Alaheimo: " + lajit[0].alaheimo + "   " + lajit[1].alaheimo + "\n" +
                        "Suku: " + lajit[0].suku + "   " + lajit[1].suku
        );
    }

    public void displayData() {
        System.out.println(
                        "Nimi: " + nimi + "\n" +
                        "Domeeni: " + domeeni + "\n" +
                        "Kunta: " + this.kunta + "\n" +
                        "Pääjakso: " + this.pääjakso + "\n" +
                        "Alajakso: " + this.alajakso + "\n" +
                        "Luokka: " + this.luokka + "\n" +
                        "Lahko: " + this.lahko + "\n" +
                        "Heimo: " + this.heimo + "\n" +
                        "Alaheimo: " + this.alaheimo + "\n" +
                        "Suku: " + this.suku
        );
    }
}
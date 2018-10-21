public class Main {

    public Main() {
        Laji meksikonkarhu = new Laji("Eucarya", "Animalia", "Chordata", "Vertebrata", "Mammalia", "Carnivora", "Ursidae", "Ursus", "arctos", "nelsoni");
        Laji kapinleijona = new Laji("Eucarya", "Animalia", "Chordata", "Vertebrata", "Mammalia", "Carnivora", "Felidae", "Panthera", "leo", "melanochaitus");
        Laji mauinkiharapyrstö = new Laji("Eucarya", "Animalia", "Chordata", "Vertebrata", "Mammalia", "Carnivora", "Felidae", "Panthera", "leo", "melanochaitus");

        meksikonkarhu.displayData(meksikonkarhu.yhdistä(kapinleijona.yhdistä(mauinkiharapyrstö)));
    }

    public static void main(String[] args) {
        new Main();
    }
}

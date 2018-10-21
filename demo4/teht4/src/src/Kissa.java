public class Kissa extends Olio {
    @Override
    protected void kohtaa(Olio o) {
        if(o instanceof Kissa) System.out.println("Kissoja syntyy mahdollisesti");
        else if(o instanceof Hiiri) System.out.println("Hiiri syödään");
        else if(o instanceof Hipsteri) System.out.println("hipsteri kohtaa eläimen");
    }
}

public class Hipsteri extends Olio {
    @Override
    protected void kohtaa(Olio o) {
        if(o instanceof Hipsteri) System.out.println("Hipsteri kohtaa hipsterin");
        else if(o instanceof Hipsteri) System.out.println("hipsteri kohtaa eläimen");
    }
}

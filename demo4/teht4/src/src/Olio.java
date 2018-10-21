public class Olio {
    protected void kohtaa(Olio o) {
        if((this instanceof Kissa && o instanceof Hiiri) || (this instanceof Hiiri && o instanceof Kissa)) System.out.println("Hiiri syödään");
        else if(this instanceof Hipsteri && (o instanceof Hiiri || o instanceof Kissa)) System.out.println("Hipsteri kohtaa eläimen");
        else if(this instanceof Kissa && o instanceof Kissa)  System.out.println("Kissoja saatta syntyä");
        else if(this instanceof Hiiri && o instanceof Hiiri)  System.out.println("Hiiriä saatta syntyä");
    }
}

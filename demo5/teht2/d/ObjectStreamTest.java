import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Ihminen luokka joka tallennetaan tiedostoon ilman toista nimeä
 */
class Ihminen implements Serializable {

    private String etunimi;

    // Tätä ei tallenneta koska sille on annettu transient "keyword"
    private transient String toinennimi;
    private String sukunimi;

    public Ihminen(String etunimi, String toinennimi, String sukunimi) {
        this.etunimi = etunimi;
        this.toinennimi = toinennimi;
        this.sukunimi = sukunimi;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer(40);
        sb.append("First Name : ");
        sb.append(this.etunimi);
        sb.append("Middle Name : ");
        sb.append(this.toinennimi);
        sb.append("Last Name : ");
        sb.append(this.sukunimi);
        return sb.toString();
    }

}

public class ObjectStreamTest {
    public static void main(String args[]) throws Exception {

        // Tehdään ihmisolio
        Ihminen ihminen = new Ihminen("Steve", "Middle","Jobs");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Ihminen"));
        // Kirjoitetaan luokka tiedostoon
        o.writeObject(ihminen);
        o.close();

        // Avataan tiedosto streamiin
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Ihminen"));
        // Luetaan luokka tiedostosta
        Ihminen ihminen1 = (Ihminen)in.readObject();
        System.out.println(ihminen1);
    }
}
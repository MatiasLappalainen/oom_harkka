import java.util.ArrayList;
import java.util.Random;

public class Colors {

    ArrayList<Color> Colors;

    public Colors() {
        String[] colors = {"#33a1ee", "#a958a5", "#cb3f68", "#2d406c", "#248e82", "#c481fb", "#28666e", "#f06261", "#ffffff", "#000000"};
        Colors = new ArrayList<Color>();


        for(String c : colors) {
            Colors.add(new Color(c, c));
        }

       testColors(Colors);

    }

    /**
     * Method will pick one pre defined colour from arrayList
     * @.pre (ArrayList =! null) &&  0<=tmp<10
     * @.post RESULT.length == 7
     */
    public String randomize(ArrayList<Color> Colors) {
        Random r = new Random();
        int tmp = r.nextInt(9);
        return Colors.get(tmp).getName();
    }


    public void testColors(ArrayList<Color> colorList) {
        System.out.println(Colors.get(0).isEqual(colorList.get(0).getName()));
        System.out.println(randomize(colorList));
    }


}

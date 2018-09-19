import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


import java.util.ArrayList;

@DisplayName("Testing Sudoku")
public class ColorTest {

    @RepeatedTest(1000)
    public void MatchColors() {
        Colors colors = new Colors();
        ArrayList<Color> Colors = colors.getColors();


        Color color1 = Colors.get(0);
        Color color2 = Colors.get(0);

        Assertions.assertTrue(color1.isEqual(color2));
    }

    @RepeatedTest(1000)
    public void NotMatchColors() {
        Colors colors = new Colors();
        ArrayList<Color> Colors = colors.getColors();


        Color color1 = Colors.get(0);
        Color color2 = Colors.get(1);

        Assertions.assertFalse(color1.isEqual(color2));
    }
}

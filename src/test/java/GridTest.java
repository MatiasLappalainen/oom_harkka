import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


public class GridTest {

    @RepeatedTest(1000)
    public void test1() {

        tetrisTest tetris1 = new tetrisTest();
        tetrisTest tetris2 = new tetrisTest();

        tetris1.setMatrix(tetris1.matrixPyramid());
        tetris2.setMatrix(tetris2.matrixPyramid());

        for(int i = 0; i < 4; i++) {
            tetris2.rotateNinety();
        }

        Assertions.assertArrayEquals(tetris1.getMatrix(), tetris2.getMatrix());
    }
}

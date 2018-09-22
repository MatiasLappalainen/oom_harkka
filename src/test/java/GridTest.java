import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;


public class GridTest {

    @RepeatedTest(1000)
    public void test1() {

        Tetris tetris1 = new Tetris();
        Tetris tetris2 = new Tetris();

        tetris1.setMatrix(tetris1.matrixPyramid());
        tetris2.setMatrix(tetris2.matrixPyramid());

        for(int i = 0; i < 4; i++) {
            tetris2.rotateNinety();
        }

        Assertions.assertArrayEquals(tetris1.getMatrix(), tetris2.getMatrix());
    }
}

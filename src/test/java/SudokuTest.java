import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing Sudoku")
class SudokuTest {

    SudokuMain sudoku;

    @BeforeEach
    void init() {
        System.out.println("Running test");
    }

    @RepeatedTest(1000)
    void test1() {

        sudoku = new SudokuMain();

        sudoku.generateSudoku();

        boolean case1 = sudoku.onSudoku();
        sudoku.rotateSudoku();
        boolean case2 = sudoku.onSudoku();

        Assertions.assertEquals(case1, case2);
    }

}

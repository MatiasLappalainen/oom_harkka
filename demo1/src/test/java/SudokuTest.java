import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@DisplayName("Testing Sudoku")
class SudokuTest {

    Sudoku sudoku;

    @BeforeEach
    void init() {
        System.out.println("Running test");
    }

    @RepeatedTest(1000)
    void test1() {

        sudoku = new Sudoku();

        sudoku.generateSudoku();

        boolean case1 = sudoku.onSudoku();
        sudoku.rotateSudoku();
        boolean case2 = sudoku.onSudoku();

        Assertions.assertEquals(case1, case2);
    }

}

import java.util.ArrayList;
import java.util.Random;

public class main {

    public main() {

        Colors colors = new Colors();

        Sudoku sudoku = new Sudoku();
        sudoku.generateSudoku();
        sudoku.displaySudoku();
        System.out.println(sudoku.onSudoku());
        sudoku.rotateSudoku();
        sudoku.displaySudoku();
        System.out.println(sudoku.onSudoku());

        tetrisTest tetris = new tetrisTest();
    }


    public static void main(String[] args) {
        new main();
    }
}


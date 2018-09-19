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

        Grid grid = new Grid(10, 10);
        grid.writeCell(0, 0, new Color("#a958a5", "#a958a5"));
        System.out.println(grid.readCell(0, 0));

    }


    public static void main(String[] args) {
        new main();
    }
}


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

        Random rand = new Random();
        // tetris.drawMatrix(tetris.matrixPyramid());
        //System.out.println();
        //tetris.drawMatrix(tetris.rotateNinety(tetris.matrixPyramid()));
        int temp = rand.nextInt(7);

        tetris.setMatrix(tetris.matrixL());
        tetris.drawMatrix();
        tetris.rotateNinety();
        tetris.drawMatrix();
        tetris.rotateNinety();
        tetris.drawMatrix();
        tetris.rotateNinety();
        tetris.drawMatrix();
        tetris.rotateNinety();
        tetris.drawMatrix();
        tetris.rotateNinety();



        /*järkyttävää paskaa +1 */
           /* if(temp == 0){
                tetris.setMatrix(tetris.matrixJ());
                tetris.drawMatrix();
                tetris.rotateNinety();
                tetris.drawMatrix();
            }
            else if(temp == 1){
                tetris.setMatrix(tetris.matrixL());
                tetris.drawMatrix();
                tetris.rotateNinety();
                tetris.drawMatrix();
            }
            else if(temp == 2){
                tetris.setMatrix(tetris.matrixSquare());
                tetris.drawMatrix();
                tetris.drawMatrix();
            }
            else if(temp == 3){
                tetris.setMatrix(tetris.matrixPyramid());
                tetris.drawMatrix();
                tetris.rotateNinety();
                tetris.drawMatrix();
            }
            else if(temp == 4){
                tetris.setMatrix(tetris.matrixLong());
                tetris.drawMatrix();
                tetris.rotateNinety();
                tetris.drawMatrix();
            }
            else if(temp == 5){
                tetris.setMatrix(tetris.matrixZag());
                tetris.drawMatrix();
                tetris.rotateNinety();
                tetris.drawMatrix();
            }
            else{
                tetris.setMatrix(tetris.matrixZig());
                tetris.drawMatrix();
                tetris.rotateNinety();
                tetris.drawMatrix();
            }*/

    }


    public static void main(String[] args) {
        new main();
    }
}


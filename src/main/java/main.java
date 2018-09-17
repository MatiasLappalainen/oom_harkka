import java.util.ArrayList;
import java.util.Random;

public class main {

    public main() {


        String[] colors = {"#33a1ee", "#a958a5", "#cb3f68", "#2d406c", "#248e82", "#c481fb", "#28666e", "#f06261", "#ffffff", "#000000"};
        ArrayList<Color> colorList = new ArrayList<Color>();


        for(String c : colors) {
            colorList.add(new Color(c, c));
        }

        System.out.println(colorList.get(0).isEqual(colorList.get(0).getName()));
        System.out.print(randomize(colorList));

       /* SudokuMain sudoku = new SudokuMain();
        sudoku.generateSudoku();
        sudoku.displaySudoku();
        System.out.println(sudoku.onSudoku());
        sudoku.rotateSudoku();
        sudoku.displaySudoku();
        System.out.println(sudoku.onSudoku());*/
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

    public static void main(String[] args) {
        new main();
    }
}


import java.util.Arrays;

class Sudoku {

    public int[][] sudoku;

    public final int koko = 9;

    /**
     * @.pre true
     * @.post sudoku.length == koko
     */
    public Sudoku() {
        this.sudoku = new int[koko][koko];
    }


    protected boolean onSudoku() {
        for (int i = 0; i < 9; i++) {

            /*Tee uudet listat,
             joiden avulla voidaan vertailla
            */
            int[] row = new int[9];
            int[] square = new int[9];

            // cloonaa sudoku i rivi
            int[] column = sudoku[i].clone();

            /*
                Lisää sudokun alkioita listoihin
            */
            for (int j = 0; j < 9; j ++) {
                row[j] = sudoku[j][i];

                // Käy läpi sudoku ruudukon
                square[j] = sudoku[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }

            // Jos jokin tarkistus on false niin palauta false
            if (!(tarkista(column) && tarkista(row) && tarkista(square)))
                return false;
        }
        return true;
    }

    // Tarkistaa onko listassa kaikki 1-9 numerot
    protected boolean tarkista(int[] check) {
        int i = 0;
        Arrays.sort(check);
        for (int number : check) {
            if (number != ++i)
                return false;
        }
        return true;
    }

    public void rotateSudoku() {
        for (int i = 0; i < koko / 2; i++) {

            for (int j = i; j < koko-i-1; j++) {
                int temp = sudoku[i][j];

                sudoku[i][j] = sudoku[j][koko-1-i];

                sudoku[j][koko-1-i] = sudoku[koko-1-i][koko-1-j];

                sudoku[koko-1-i][koko-1-j] = sudoku[koko-1-j][i];

                sudoku[koko-1-j][i] = temp;
            }
        }
    }

    public void generateSudoku() {
        int k=1,n=1;
        for(int i=0;i<9;i++) {
            k=n;
            for(int j=0;j<9;j++) {
                if(k<=9){
                    sudoku[i][j]=k;
                    k++;
                }else{
                    k=1;
                    sudoku[i][j]=k;
                    k++;
                }
            }
            n=k+3;
            if(k==10)
                n=4;
            if(n>9)
                n=(n%9)+1;
        }
    }


    public void displaySudoku() {
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                System.out.print(" " + sudoku[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }
}
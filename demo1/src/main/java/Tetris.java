import java.util.*;

public class Tetris {

    public String[][] matrix = new String[4][4];

    /**
     * @.pre true
     * @.post (matrix == String[][] && matrix != null)
     */
    public String[][] matrixJ() {
        int i = 0;
        while (i < 3) {
            matrix[1][i] = "*";
            i++;
        }
        matrix[0][2] = "*";
        return matrix;
    }

    /**
     * @.pre true
     * @.post (matrix == String[][] && matrix != null)
     */
    public String[][] matrixL() {

        int i = 0;
        while (i < 3) {
            matrix[1][i] = "*";
            i++;
        }
        matrix[2][2] = "*";
        return matrix;
    }

    /**
     * @.pre true
     * @.post (matrix == String[][] && matrix != null)
     */
    public String[][] matrixSquare() {

        for (int i = 0; i < 2; i++) {
            int a = 0;
            while (a < 2) {
                matrix[i][a] = "*";
                a++;
            }
        }
        return matrix;
    }

    /**
     * @.pre true
     * @.post (matrix == String[][] && matrix != null)
     */
    public String[][] matrixLong() {
        for (int i = 0; i < 4; i++) {
            matrix[i][0] = "*";
        }
        return matrix;
    }

    /**
     * @.pre true
     * @.post (matrix == String[][] && matrix != null)
     */
    public String[][] matrixZig() {

        for (int i = 1; i < 3; i++) {
            matrix[i][0] = "*";
        }
        for (int a = 0; a < 2; a++) {
            matrix[a][1] = "*";
        }
        return matrix;
    }

    /**
     * @.pre true
     * @.post (matrix == String[][] && matrix != null)
     */
    public String[][] matrixZag() {

        for (int i = 0; i < 2; i++) {
            matrix[i][0] = "*";
        }
        for (int a = 1; a < 3; a++) {
            matrix[a][1] = "*";
        }
        return matrix;
    }

    /**
     * @.pre true
     * @.post (matrix == String[][] && matrix != null)
     */
    public String[][] matrixPyramid() {

        matrix[1][0] = "*";
        for (int i = 0; i < 3; i++) {
            matrix[i][1] = "*";
        }
        return matrix;
    }

    public void drawMatrix() {
        for (int b = 0; b < matrix.length; b++) {
            for (int a = 0; a < matrix.length; a++) {
                if (matrix[a][b] == null) {
                    matrix[a][b] = " ";
                }
                System.out.print(matrix[a][b]);
            }
            System.out.println();
        }
    }

    /**
     * Generates random matrix
     * 
     * @.pre true
     * @.post temp in range 0:6
     */
    public void randomMatrix() {
        Random r = new Random();

        int temp = r.nextInt(7);
        // If-else structure for seven possible scenarios
        if (temp == 0) {
            setMatrix(matrixJ());
        } else if (temp == 1) {
            setMatrix(matrixL());
        } else if (temp == 2) {
            setMatrix(matrixSquare());

        } else if (temp == 3) {
            setMatrix(matrixPyramid());
        } else if (temp == 4) {
            setMatrix(matrixLong());

        } else if (temp == 5) {
            setMatrix(matrixZag());

        } else {
            setMatrix(matrixZig());

        }
    }


    public void rotateNinety() {
        String[][] tmpMatrix = new String[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                String tmp = matrix[i][j];

                tmpMatrix[j][matrix.length - i - 1] = tmp;
            }
        }

        setMatrix(tmpMatrix);
    }

    // Getterit ja Setterit
    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public String[][] getMatrix() {
        return matrix;
    }

}
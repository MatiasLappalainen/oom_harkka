import java.util.*;
public class tetrisTest {

    public String[][] matrix = new String[4][4];

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public String[][] matrixJ(){
    int i = 0;
    while (i < 3){
        matrix[1][i] = "*";
        i++;
    }
    matrix[0][2] = "*";
    return matrix;
}

public String[][] matrixL(){

    int i = 0;
    while (i < 3){
        matrix[1][i] = "*";
        i++;
    }
    matrix[2][2] = "*";
    return matrix;
}

public String[][] matrixSquare(){

    for(int i = 0; i < 2; i++){
        int a = 0;
        while(a < 2){
            matrix[i][a] = "*";
            a++;
        }
    }
    return matrix;
}

public String[][] matrixLong(){
    for(int i = 0; i < 4; i++){
        matrix[i][2] = "*";
    }
    return matrix;
}

public String[][] matrixZig(){

    for(int i = 1; i < 3; i++){
        matrix[i][0] = "*";
    }   
    for(int a = 0; a < 2; a++){
        matrix[a][1] = "*";
        }
    return matrix;
}

public String[][] matrixZag(){

    for(int i = 0; i < 2; i++){
        matrix[i][0] = "*";
    }
    for(int a = 1; a < 3; a++){
        matrix[a][1] = "*";
    }
    return matrix;
}

public String[][] matrixPyramid(){

    matrix[1][0] = "*";
    for(int i = 0; i < 3; i++){
        matrix[i][1] = "*";
    }
    return matrix;
}

public void drawMatrix(){
    for(int b = 0; b < matrix.length; b++){
        for(int a = 0; a < matrix.length; a++){
            if (matrix[a][b] == null){
                matrix[a][b] = " ";
        }
        System.out.print(matrix[a][b]);
    }
    System.out.println();
}
}

public void rotateNinety(){
    String[][] tmpMatrix = new String[matrix.length][matrix.length];
    for(int i  = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix.length; j++) {
            String tmp =  matrix[i][j];

            tmpMatrix[j][matrix.length-i-1] = tmp;
        }
    }

    setMatrix(tmpMatrix);
}
}
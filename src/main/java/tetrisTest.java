import java.util.*;
public class tetrisTest {
    public static void main(String[] args){
        
        Random rand = new Random();
        drawMatrix(matrixPyramid());
        System.out.println();
        drawMatrix(rotateNinety(matrixPyramid()));
        /**järkyttävää paskaa */
        /*while(true){
        if(rand.nextInt(7) == 0){
            drawMatrix(matrixJ());
        }
        else if(rand.nextInt(7) == 1){
            drawMatrix(matrixL());
        }
        else if(rand.nextInt(7) == 2){
            drawMatrix(matrixSquare());
        }
        else if(rand.nextInt(7) == 3){
            drawMatrix(matrixLong());
        }
        else if(rand.nextInt(7) == 4){
            drawMatrix(matrixZag());
        }
        else if(rand.nextInt(7) == 5){
            drawMatrix(matrixZig());
        }
        else{
            drawMatrix(matrixPyramid());
        }
        break;
    }*/
}

public static String[][] matrixJ(){
    String[][] matrix = new String[3][3];
    int i = 0;
    while (i < 3){
        matrix[1][i] = "*";
        i++;
    }
    matrix[0][2] = "*";
    return matrix;
}

public static String[][] matrixL(){
    String[][] matrix = new String[3][3];
    int i = 0;
    while (i < 3){
        matrix[1][i] = "*";
        i++;
    }
    matrix[2][2] = "*";
    return matrix;
}

public static String[][] matrixSquare(){
    String[][] matrix = new String[2][2];
    for(int i = 0; i < 2; i++){
        int a = 0;
        while(a < 2){
            matrix[i][a] = "*";
            a++;
        }
    }
    return matrix;
}

public static String[][] matrixLong(){
    String[][] matrix = new String[4][4];
    for(int i = 0; i < 4; i++){
        matrix[i][2] = "*";
    }
    return matrix;
}

public static String[][] matrixZig(){
    String[][] matrix = new String[3][3];
    for(int i = 1; i < 3; i++){
        matrix[i][0] = "*";
    }   
    for(int a = 0; a < 2; a++){
        matrix[a][1] = "*";
        }
    return matrix;
}

public static String[][] matrixZag(){
    String[][] matrix = new String[3][3];
    for(int i = 0; i < 2; i++){
        matrix[i][0] = "*";
    }
    for(int a = 1; a < 3; a++){
        matrix[a][1] = "*";
    }
    return matrix;
}

public static String[][] matrixPyramid(){
    String[][] matrix = new String[3][3];
    matrix[1][0] = "*";
    for(int i = 0; i < 3; i++){
        matrix[i][1] = "*";
    }
    return matrix;
}

public static void drawMatrix(String[][] matrix){
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

public static String[][] rotateNinety(String[][] matrix){
    String[][] tmpMatrix = new String[matrix.length][matrix.length];
    for(int i = 0; i < matrix.length; i++){
        for(int a = 0; a < matrix.length; a++){
            if(matrix[i][a] == "*"){
                tmpMatrix[a][i] = "*";
            }
        }
    }
    return tmpMatrix;
}
}
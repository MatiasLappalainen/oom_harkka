public class Grid {

    int width;
    int height;
    Color[][] grid;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Color[width][height];
        Color color = new Color("#a958a5", "#a958a5");
    }

    void setWidth(int width) {
        this.width = width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    Color readCell(int x, int y) {
        return grid[x][y];
    }

    void writeCell(int x, int y, Color newColor) {
        grid[x][y] = newColor;
    }

    Color[][] addMirrored(int x, int y, Color color) {
        
        Color[][] matrix = new Color[width * 2][height * 2];

        matrix[x][y] = color;
        matrix[x][y*2] = color;
        matrix[x*2][y] = color;
        matrix[x*2][y*2] = color;

        return matrix;
    }

    public void displayMatrix(Color[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == null) matrix[i][j] = new Color(" ", " ");
                System.out.print(" " + matrix[i][j].getHex());
            }
            System.out.println();
        }
    }
}
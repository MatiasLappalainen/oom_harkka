public class Grid {

    int width;
    int height;
    Color[][] grid;

    /**
     * Määrittää uuden grid olion
     * @.pre (width != null && width > 0 && height != null && height > 0)
     * @.post true
    **/
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Color[width][height];
        Color color = new Color("#a958a5", "#a958a5");
    }


    // Getters and setters
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

    /**
     * Lukee taulukosta annetun solun ja palauttaa sen
     * @.pre (x > 0 && x != null && y > 0 && y != null)
     * @.post (grid == Object Color || grid == null)
     */
    Color readCell(int x, int y) {
        return grid[x][y];
    }

    /**
     * Kirjoittaa taulukkoon uuden väri-arvon kohtaan x ja y
     * @.pre (x > 0 && x != null && y > 0 && y != null && newColor != null)
     * @.post true
     **/
    void writeCell(int x, int y, Color newColor) {
        grid[x][y] = newColor;
    }

    /**
     * Ottaa yhden pisteen ja palauttaa kolme muuta peilattuna
     * @.pre (x > 0 && x != null && y > 0 && y != null && color == Object Color)
     * @.post matrix.length >= 4
     */
    Color[][] addMirrored(int x, int y, Color color) {
        
        Color[][] matrix = new Color[width * 2][height * 2];

        matrix[x][y] = color;
        matrix[x][y*2] = color;
        matrix[x*2][y] = color;
        matrix[x*2][y*2] = color;

        return matrix;
    }

    /**
     * @.pre matrix != null
     * @.post true
     * */
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
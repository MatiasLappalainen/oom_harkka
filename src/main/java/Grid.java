package main.java;

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
        this.x = x;
        this.y = y;
        this.newColor = new Color();
    }

    //Color readCell(int x, int y);
      //  void writeCell(int x, int y, Color newColor);
}
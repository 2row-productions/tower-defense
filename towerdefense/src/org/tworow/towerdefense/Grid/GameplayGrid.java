package org.tworow.towerdefense.Grid;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameplayGrid {

    private final static int PADDING = 10;
    private int cols;
    private int rows;
    private int CELL_SIZE = 50;
    private Rectangle grid;

    public GameplayGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

        grid = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        grid.setColor(Color.RED);

    }

    public void init(){
        grid.fill();
        generateCells();
    }

    // Create individual cells where characters are instantiated
    public void generateCells() {

        int PADDING2 = PADDING;

        for (int i=0; i<cols; i++){
            Rectangle cell1 = new Rectangle(PADDING2, PADDING, CELL_SIZE, CELL_SIZE);

            if (i % 2 == 0) {
                cell1.setColor(Color.BLACK);
            } else {
                cell1.setColor(Color.WHITE);
            }

            cell1.fill();

            for (int j=0; j<rows; j++) {

                Rectangle cell2 = new Rectangle(PADDING2, PADDING + (CELL_SIZE*j), CELL_SIZE, CELL_SIZE);

                if (j % 2 != 0 && i % 2 != 0) {
                    cell2.setColor(Color.WHITE);
                }

                if (j % 2 != 0 &&  i % 2 == 0) {
                    cell2.setColor(Color.BLACK);
                }

                if (j % 2 == 0 && i % 2 != 0) {
                    cell2.setColor(Color.BLACK);
                }

                if (j % 2 == 0 && i % 2 == 0) {
                    cell2.setColor(Color.WHITE);
                }

                cell2.fill();

            }

            PADDING2 += CELL_SIZE;
        }
    }

    public int getWidth(){
        return cols * CELL_SIZE;
    }

    public int getHeight(){
        return rows * CELL_SIZE;
    }





}

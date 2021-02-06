package org.tworow.towerdefense.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;

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

        // Thread.sleep();
        AttackerFactory.createAttacker(this);
        DefenderFactory.createDefender(this, 0, 0);
    }

    // Create individual cells where characters are instantiated
    public void generateCells() {
        int PADDING2 = PADDING;
        /*for (int x = 0; x < cols; x++) {
            Rectangle rect = new Rectangle(PADDING + (x * CELL_SIZE) + (PADDING * x), PADDING, CELL_SIZE, CELL_SIZE);
            rect.setColor(Color.LIGHT_GRAY);
            rect.fill();
            for (int y = 0; y < rows; y++) {
                Rectangle rect2 = new Rectangle(PADDING + (x * CELL_SIZE) + (x * PADDING), PADDING + (CELL_SIZE * y) + (PADDING * y), CELL_SIZE, CELL_SIZE);
                rect2.setColor(Color.LIGHT_GRAY);
                rect2.fill();
            }
        }
    }*/

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

    public void createAttacker() {
        AttackerFactory.createAttacker(this);
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth(){
        return cols * CELL_SIZE;
    }

    public int getHeight(){
        return rows * CELL_SIZE;
    }

    public int getPadding() {
        return PADDING;
    }

}

package org.tworow.towerdefense.Character;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Grid.GameplayGrid;

abstract public class Character {

    private int CELL_SIZE = 50;
    private int col;
    private int row;
    private boolean shouldNotMove;
    private boolean isDead;
    private boolean isMoving = true;
    private GameplayGrid grid;
    private Picture shape;

    public Character(GameplayGrid grid, int col, int row) {
        this.grid = grid;
        this.col = col;
        this.row = row;
    }

    abstract public void move();

    public boolean isDead() {
        return true;
    }

    public int getCol() {
        return col;
    }

    public void updateColToLeft(){
        col -= CELL_SIZE;
    }

    public void updateRowToDown() {
        row += CELL_SIZE;
    }

    public void updateRowToUp() {
        row -= CELL_SIZE;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getSize() {
        return CELL_SIZE;
    }

    public GameplayGrid getGrid() {
        return grid;
    }

    public Picture getShape() {
        return shape;
    }

    public void setShape(Picture shape) {
        this.shape = shape;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}

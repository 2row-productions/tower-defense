package org.tworow.towerdefense.Character;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Grid.GameplayGrid;

abstract public class Character {

    private int CELL_SIZE = 50;
    private int col;
    private int row;
    private boolean isDead;
    private GameplayGrid grid;
    private Rectangle shape;

    public Character(GameplayGrid grid, int col, int row) {
        this.grid = grid;
        this.col = col;
        this.row = row;
    }

    public boolean isDead() {
        return true;
    }

    public int getCol() {
        return col;
    }

    protected void updateCol(){
        col -= CELL_SIZE/10;
    }

    public int getRow() {
        return row;
    }

    public int getSize() {
        return CELL_SIZE;
    }

    public GameplayGrid getGrid() {
        return grid;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setShape(Rectangle shape) {
        this.shape = shape;
    }
}

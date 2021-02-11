package org.tworow.towerdefense.Projectile;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Projectile {
    private final int CELL_SIZE = 10;
    private int damage;
    private int col;
    private int row;
    private Rectangle shape;
    private GameplayGrid grid;


    public Projectile(GameplayGrid grid, int col, int row, int damage) {
        this.grid = grid;
        this.damage = damage;
        this.col = col;
        this.row = row;

        Rectangle shape = new Rectangle(col, row + grid.getCellsize()/2 + grid.getPadding()/2, CELL_SIZE, CELL_SIZE);
        shape.setColor(Color.BLACK);
        shape.fill();
        this.shape = shape;
    }

    public GameplayGrid getGrid() {
        return grid;
    }

    public void updateProjectileCol(){
        // this operation has to return 2
        // be careful changing cell size
        // we don´t know what we did, but it works xD
        col += (CELL_SIZE/(grid.getCellsize()/CELL_SIZE));
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public void move() {
        updateProjectileCol();
        shape.translate(getGrid().getCellsize()/20 , 0);
    }

    public Rectangle getShape() {
        return shape;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}

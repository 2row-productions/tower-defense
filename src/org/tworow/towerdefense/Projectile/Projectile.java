package org.tworow.towerdefense.Projectile;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Projectile {
    private final int CELL_SIZE = 10;
    private int damage;
    private int col;
    private int row;
    private Rectangle projectile;
    private GameplayGrid grid;

    public Projectile(GameplayGrid grid, int col, int row, int damage) {
        this.grid = grid;
        this.damage = damage;
        this.col = col;
        this.row = row;

        projectile = new Rectangle(col, row, CELL_SIZE, CELL_SIZE);
        projectile.setColor(Color.BLACK);
        projectile.fill();
    }

    public GameplayGrid getGrid() {
        return grid;
    }

    public void updateProjectileCol(){
        col += CELL_SIZE;
    }

    public void move() {
        updateProjectileCol();
        projectile.translate(getGrid().getCellsize(), 0);
    }

}

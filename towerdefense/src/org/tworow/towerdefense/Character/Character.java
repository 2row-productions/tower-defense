package org.tworow.towerdefense.Character;

import org.tworow.towerdefense.Game;
import org.tworow.towerdefense.Grid.GameplayGrid;

abstract public class Character {

    private int size = 50;
    private int col;
    private int row;
    private int health;
    private boolean isDead = false;
    private GameplayGrid grid;

    public Character(GameplayGrid grid, int health, int col, int row) {
        this.grid = grid;
        this.health = health;
        this.col = col;
        this.row = row;
    }

    public void takeDamage(int damage) {
        health = getHealth() - damage;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return isDead;
    }

    public int getCol() {
        return col;
    }

    protected void goLeft(){
        col -= size;
    }

    public int getRow() {
        return row;
    }

    public int getSize() {
        return size;
    }

    public GameplayGrid getGrid() {
        return grid;
    }
}

package org.tworow.towerdefense.Character;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Grid.GameplayGrid;

import java.awt.*;

abstract public class Character {

    private int size = 50;
    private int col;
    private int row;
    private int health;
    private boolean isDead = false;
    private int damage;
    private GameplayGrid grid;
    private Rectangle rectangle;

    public Character(GameplayGrid grid, int health, int col, int row, int damage) {
        this.grid = grid;
        this.health = health;
        this.col = col;
        this.row = row;
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        health = getHealth() - damage;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return health == 0;
    }


    public int getCol() {
        return col;
    }

    protected void updateCol(){
        col -= size;
    }

    public int getRow() {
        return row;
    }

    public int getSize() {
        return size;
    }

    public int getDamage() {
        return damage;
    }

    public GameplayGrid getGrid() {
        return grid;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}

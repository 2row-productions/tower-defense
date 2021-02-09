package org.tworow.towerdefense.Character.Attacker;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;


public class Attacker extends Character {

    private Rectangle attacker;
    private int moves;
    private final int MOVE_LIMITER = (int) (Math.random() * 10) + 3;
    private boolean isMoving = true;

    public Attacker(GameplayGrid grid, int health, int col, int row, int damage) {
        super(grid, health, col, row, damage);

        moves = 0;
        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        setRectangle(new Rectangle(attackerCol, attackerRow, getSize(), getSize()));
        getRectangle().setColor(Color.YELLOW);
        getRectangle().fill();

    }

    public void move() {

        moves++;

        if (moves % MOVE_LIMITER == 0 && isMoving) {
            updateCol();
            getRectangle().translate(-(getGrid().getCellsize()), 0);
        }

        isMoving = true;
    }
    public void stop(){
        isMoving = false;
    }

}

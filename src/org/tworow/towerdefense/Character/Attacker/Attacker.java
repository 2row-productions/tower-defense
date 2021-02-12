package org.tworow.towerdefense.Character.Attacker;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;


public class Attacker extends Character {

    private int moves;
    private final int MOVE_LIMITER = (int) (Math.random() * 10) + 3;
    private boolean isMoving = true;
    private boolean reachedBase;

    public Attacker(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        moves = 0;
        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        Rectangle shape = new Rectangle(attackerCol, attackerRow, getSize(), getSize());
        shape.setColor(Color.YELLOW);
        shape.fill();
        setShape(shape);
    }

    public void move() {

        moves++;

        if (moves % MOVE_LIMITER == 0 && isMoving) {
            updateCol();
            getShape().translate(-(getGrid().getCellsize() / 10), 0);
        }

        isMoving = true;
    }

    public boolean getReachedBase() {
        return reachedBase;
    }

    public void setReachedBase() {
        reachedBase = true;
    }
}

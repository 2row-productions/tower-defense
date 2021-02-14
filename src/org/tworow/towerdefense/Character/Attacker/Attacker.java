package org.tworow.towerdefense.Character.Attacker;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;


public class Attacker extends Character {

    private int moves;
    private final int MOVE_LIMITER = (int) (Math.random() * 10) + 3;
    private boolean reachedBase;

    public Attacker(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        moves = 0;
        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        Picture shape = new Picture(attackerCol, attackerRow, "resources/food/chocolate1.png");
        shape.draw();
        setShape(shape);
    }

    @Override
    public void updateColToLeft() {
        setCol(getCol() - getGrid().getCellsize()/10);
    }

    @Override
    public void move() {

        moves++;

        if (moves % MOVE_LIMITER == 0 && isMoving()) {
            updateColToLeft();
            getShape().translate(-(getGrid().getCellsize() / 10), 0);
        }

        setMoving(true);
    }

    public boolean getReachedBase() {
        return reachedBase;
    }

    public void setReachedBase() {
        reachedBase = true;
    }
}

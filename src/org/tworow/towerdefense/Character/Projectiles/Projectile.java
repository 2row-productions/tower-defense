package org.tworow.towerdefense.Character.Projectiles;

import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;


public class Projectile extends Character {

    private int moves;
    private final int MOVE_LIMITER = (int) (Math.random() * 10) + 3;
    private boolean reachedBase;
    private boolean alreadyHit;
    private boolean isFlying;

    public Projectile(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        moves = 0;
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

    public void setAlreadyHit(boolean alreadyHit) {
        this.alreadyHit = alreadyHit;
    }

    public boolean isAlreadyHit() {
        return alreadyHit;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public boolean isFlying() {
        return isFlying;
    }
}

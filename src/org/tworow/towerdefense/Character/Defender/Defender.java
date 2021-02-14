package org.tworow.towerdefense.Character.Defender;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Defender extends Character {

    private boolean isEating;
    private boolean isHit;
    private boolean isTeleporting;

    public Defender(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        int defenderCol = col + grid.getPadding();
        int defenderRow = row + grid.getPadding();

        Picture shape = new Picture(defenderCol, defenderRow, "resources/buu/buu.png");
        shape.draw();
        setShape(shape);
    }

    public void setEating(boolean eating) {
        isEating = eating;
    }

    public boolean isEating() {
        return isEating;
    }

    public boolean isTeleporting() {
        return isTeleporting;
    }

    public void setTeleporting(boolean teleporting) {
        isTeleporting = teleporting;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean isHit() {
        return isHit;
    }

    @Override
    public void move() {
        // if (!isMoving()) return;

    }

}

package org.tworow.towerdefense.Character.Defender;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Defender extends Character {

    private boolean isEating;

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

    @Override
    public void move() {
        // if (!isMoving()) return;

    }

}

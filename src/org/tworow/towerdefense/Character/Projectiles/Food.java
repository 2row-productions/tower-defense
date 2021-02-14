package org.tworow.towerdefense.Character.Projectiles;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Food extends Projectile {

    private Picture shape;

    public Food(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();


        int shapeRandomizer = (int) (Math.random() * 4);

        if (shapeRandomizer == 0) {
            shape = new Picture(attackerCol, attackerRow, "resources/food/chocolate1.png");
        }

        if (shapeRandomizer == 1) {
            shape = new Picture(attackerCol, attackerRow, "resources/food/chocolate2.png");

        }

        if (shapeRandomizer == 2) {
            shape = new Picture(attackerCol, attackerRow, "resources/food/chocolate3.png");

        }

        if (shapeRandomizer == 3) {
            shape = new Picture(attackerCol, attackerRow, "resources/food/chocolate4.png");

        }

        shape.draw();
        setShape(shape);
    }
}
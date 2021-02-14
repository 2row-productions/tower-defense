package org.tworow.towerdefense.Character.Attacker;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Enemy extends Attacker {

    private Picture shape;

    public Enemy(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        shape = new Picture(attackerCol, attackerRow, "resources/enemy/saibamen-large.png");
        shape.draw();
        setShape(shape);
    }

}

package org.tworow.towerdefense.Character.Defender;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Defender extends Character {

    public Defender(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        int defenderCol = col + grid.getPadding();
        int defenderRow = row + grid.getPadding();

        Rectangle shape = new Rectangle(defenderCol, defenderRow, getSize(), getSize());
        shape.setColor(Color.GREEN);
        shape.fill();
        setShape(shape);
    }

}

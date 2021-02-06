package org.tworow.towerdefense.Character.Defender;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Defender extends Character {

    public Defender(GameplayGrid grid, int health, int col, int row) {
        super(grid, health, col, row);

        int defenderCol = col + grid.getPadding();
        int defenderRow = row + grid.getPadding();

        Rectangle defender = new Rectangle(defenderCol, defenderRow, getSize(), getSize());
        defender.setColor(Color.GREEN);
        defender.fill();

    }

    public void shoot() {

    }
}

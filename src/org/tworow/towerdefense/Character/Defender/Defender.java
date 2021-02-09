package org.tworow.towerdefense.Character.Defender;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;
import org.tworow.towerdefense.Projectile.Projectile;

public class Defender extends Character {

    public Defender(GameplayGrid grid, int health, int col, int row, int damage) {
        super(grid, health, col, row, damage);

        int defenderCol = col + grid.getPadding();
        int defenderRow = row + grid.getPadding();

        setRectangle(new Rectangle(defenderCol, defenderRow, getSize(), getSize()));
        getRectangle().setColor(Color.GREEN);
        getRectangle().fill();

    }

    public Projectile shoot() {
        return new Projectile(getGrid(), getCol(), getRow(), getDamage());
    }
}

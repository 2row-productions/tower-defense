package org.tworow.towerdefense.Character.Attacker;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;


public class Attacker extends Character {

    public Attacker(GameplayGrid grid, int health, int col, int row) {
        super(grid, health, col, row);

        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        Rectangle attacker = new Rectangle(attackerCol, attackerRow, getSize(), getSize());
        attacker.setColor(Color.YELLOW);
        attacker.fill();
    }

    public void move() {

    }

}

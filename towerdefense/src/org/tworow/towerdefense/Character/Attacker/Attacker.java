package org.tworow.towerdefense.Character.Attacker;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;


public class Attacker extends Character {

    private Rectangle attacker;
    private int moves;
    private final int MOVE_LIMITER = (int) (Math.random() * 10) + 3;


    public Attacker(GameplayGrid grid, int health, int col, int row) {
        super(grid, health, col, row);

        moves = 0;
        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        attacker = new Rectangle(attackerCol, attackerRow, getSize(), getSize());
        attacker.setColor(Color.YELLOW);
        attacker.fill();

    }

    public void move() {

        moves++;

        if(moves % MOVE_LIMITER == 0) {
            goLeft();
            attacker.translate(-(getGrid().getCellsize()), 0);
        }
    }

}

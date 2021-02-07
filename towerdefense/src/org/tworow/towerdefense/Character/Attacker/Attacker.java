package org.tworow.towerdefense.Character.Attacker;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Character;
import org.tworow.towerdefense.Grid.GameplayGrid;


public class Attacker extends Character {

    private Rectangle attacker;


    public Attacker(GameplayGrid grid, int health, int col, int row) {
        super(grid, health, col, row);

        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        attacker = new Rectangle(attackerCol, attackerRow, getSize(), getSize());
        attacker.setColor(Color.YELLOW);
        attacker.fill();


        attacker.translate(-grid.getCellsize(), 0);



    }

    public void move() {

        try {
            Thread.sleep(200) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        attacker.translate(-(getGrid().getCellsize()), 0);

    }

}

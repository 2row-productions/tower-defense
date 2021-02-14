package org.tworow.towerdefense.Character.Projectiles;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Enemy extends Projectile {

    private Picture shape;
    private Sound sound;

    public Enemy(GameplayGrid grid, int col, int row) {
        super(grid, col, row);

        int attackerCol = col - getSize() + grid.getPadding();
        int attackerRow = row + grid.getPadding();

        shape = new Picture(attackerCol, attackerRow, "resources/enemy/enemy-teleporting.png");
        shape.draw();
        setShape(shape);


        sound = new Sound("/resources/sounds/instant.wav");
        sound.play(true);
    }

}

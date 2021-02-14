package org.tworow.towerdefense;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Character.Defender.Defender;

public class Movement {

    private Defender defender;
    private Sound teleportingSound;
    private int distance;

    public Movement(Defender defender) {
        this.defender = defender;
        distance = defender.getGrid().getCellsize();
    }

    public void moveDown() {
        if (defender.getRow() == defender.getGrid().getHeight()) return;

       // defender.setTeleporting(true);
       // defender.getShape().delete();
       // defender.setShape(new Picture(defender.getCol(), defender.getRow(), "resources/buu/teleport.png"));
       // defender.getShape().draw();
        defender.getShape().translate(0, distance);
        defender.updateRowToDown();
    }

    public void moveUp() {
        if (defender.getRow() == 0) return;

        //defender.setTeleporting(true);
        //defender.getShape().delete();
        //defender.setShape(new Picture(defender.getCol(), defender.getRow(), "resources/buu/teleport.png"));
        //defender.getShape().draw();
        defender.getShape().translate(0, -distance);
        defender.updateRowToUp();

    }
}

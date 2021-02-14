package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Defender.Defender;

public class Movement {

    private Defender defender;
    private int distance;

    public Movement(Defender defender) {
        this.defender = defender;
        distance = defender.getGrid().getCellsize();
    }

    public void moveDown() {
        if (defender.getRow() == defender.getGrid().getHeight()) return;

        defender.getShape().translate(0, distance);
        defender.updateRowToDown();
    }

    public void moveUp() {
        if (defender.getRow() == 0) return;

        defender.getShape().translate(0, -distance);
        defender.updateRowToUp();
    }
}

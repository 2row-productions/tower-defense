package org.tworow.towerdefense.Character.Attacker;

import org.tworow.towerdefense.Grid.GameplayGrid;

public class AttackerFactory {

    public static Attacker createAttacker(GameplayGrid grid) {

        return new Attacker(grid, 4,  grid.getWidth(), (int) (Math.random() * grid.getRows()) * grid.getCellsize());



    }
}

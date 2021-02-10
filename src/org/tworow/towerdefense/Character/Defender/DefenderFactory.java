package org.tworow.towerdefense.Character.Defender;

import org.tworow.towerdefense.Grid.GameplayGrid;

public class DefenderFactory {

    public static Defender createDefender(GameplayGrid grid, int col, int row, int damage ) {

        return new Defender(grid, 20, col * grid.getCellsize(), row * grid.getCellsize(), damage);
    }
}

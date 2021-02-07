package org.tworow.towerdefense.Character.Defender;

import org.tworow.towerdefense.Grid.GameplayGrid;

public class DefenderFactory {

    public static Defender createDefender(GameplayGrid grid, int col, int row ) {

        return new Defender(grid, 4, col * grid.getCellsize(), row * grid.getCellsize());
    }
}

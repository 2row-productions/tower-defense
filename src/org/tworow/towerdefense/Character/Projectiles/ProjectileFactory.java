package org.tworow.towerdefense.Character.Projectiles;

import org.tworow.towerdefense.Grid.GameplayGrid;

public class ProjectileFactory {

    public static Projectile createAttacker(GameplayGrid grid) {

        int attackerRandomizer = (int) (Math.random()*2);
        int rowRandomizer = (int) (Math.random() * grid.getRows()) * grid.getCellsize();

        if (attackerRandomizer == 0) {
            return new Food(grid,  grid.getWidth(), rowRandomizer);
        }

        return new Enemy(grid, grid.getWidth(), rowRandomizer);
    }
}

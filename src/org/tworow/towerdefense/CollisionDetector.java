package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Projectiles.Projectile;
import org.tworow.towerdefense.Character.Projectiles.Enemy;
import org.tworow.towerdefense.Character.Defender.Defender;

public class CollisionDetector {

    public boolean checkBase(Projectile projectile) {
        return projectile.getCol() <= projectile.getSize() && !(projectile instanceof Enemy);
    }

    public boolean checkDefender(Projectile projectile, Defender defender) {

        return projectile.getCol() == defender.getCol() + defender.getSize() + 30
                && projectile.getRow() == defender.getRow();
    }

}

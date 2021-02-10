package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Grid.GameplayGrid;
import org.tworow.towerdefense.Projectile.Projectile;

public class CollisionDetector {

    public boolean checkProjectile(Projectile projectile, Attacker attacker) {

        // if projectile collides with attacker, disappear and attacker takes damage
        // the 10 is the equivalent to PADDING
        return projectile.getCol() >= attacker.getCol() - attacker.getSize()
                && projectile.getRow() == attacker.getRow();
    }

    public boolean checkBase(Attacker attacker) {

        return attacker.getCol() <= attacker.getSize();
    }

    public boolean checkLimit(Projectile projectile, GameplayGrid grid) {
        return projectile.getCol() >= grid.getWidth();
    }

    public boolean checkDefender(Attacker attacker, Defender defender) {

        //if attacker collides with defender, stop moving;
        return attacker.getCol() == defender.getCol() + defender.getSize()
                && attacker.getRow() == defender.getRow();
    }

}

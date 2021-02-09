package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Projectile.Projectile;

public class CollisionDetector {

    public void checkProjectile(Projectile projectile, Attacker attacker) {

    }

    public void checkCharacter() {

    }

    public boolean checkBase(Attacker attacker) {

        return attacker.getCol() <= 0;
    }

    public boolean checkDefender(Attacker attacker, Defender defender) {
        //if attacker collides with defender --> stop moving;
        return attacker.getCol() == defender.getCol() + defender.getSize()
                && attacker.getRow() == defender.getRow();
    }

}

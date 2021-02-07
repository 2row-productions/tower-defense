package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Projectile.Projectile;

public class CollisionDetector {

    public void checkProjectile(Projectile projectile, Attacker attacker) {

    }

    public void checkCharacter() {

    }

    public void checkBase(Attacker attacker) {

        if (attacker.getCol() <= 0) {
            // finishGame();
            System.out.println("Finish Game!");
        }
    }

}

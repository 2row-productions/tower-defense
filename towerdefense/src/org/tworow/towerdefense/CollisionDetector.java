package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;

public class CollisionDetector {

    public void checkProjectile() {

    }

    public void checkCharacter() {

    }

    public void checkBase(Attacker attacker) {
        System.out.println(attacker.getCol());
        if (attacker.getCol() <= 0) {
            System.out.println("Finish Game!");

        }
    }

}

package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Defender.Defender;

public class CollisionDetector {

    public boolean checkBase(Attacker attacker) {
        return attacker.getCol() <= attacker.getSize();
    }

    public boolean checkDefender(Attacker attacker, Defender defender) {

        return attacker.getCol() == defender.getCol() + defender.getSize() + 30
                && attacker.getRow() == defender.getRow();
    }

}

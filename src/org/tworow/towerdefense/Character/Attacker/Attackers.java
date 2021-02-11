package org.tworow.towerdefense.Character.Attacker;

import java.util.ArrayList;
import java.util.Iterator;

public class Attackers implements Iterable<Attacker> {

    private ArrayList<Attacker> attackersList;

    public Attackers() {
        attackersList = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return attackersList.listIterator();
    }

    public void add(Attacker attacker) {
        attackersList.listIterator().add(attacker);
    }

    public void remove() {
        attackersList.listIterator().remove();
    }
}

package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Game {

    private GameplayGrid grid;
    private CollisionDetector collisionDetector;
    private int numberOfAttackers = 5;
    private Attacker[] attackers;

    public Game(int cols, int rows) {

        this.grid = new GameplayGrid(cols, rows);
    }

    public void init() {

        grid.init();
        start();
    }

    public void start() {

        // defenders test
        DefenderFactory.createDefender(grid, 2, 0);
        DefenderFactory.createDefender(grid, 1, 2);

        attackers = new Attacker[numberOfAttackers];

        while (true) {
            try {
                Thread.sleep(200) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // instantiates attackers
            for (int i = 0; i < numberOfAttackers; i++) {
                if(attackers[i] == null) {
                    attackers[i] = AttackerFactory.createAttacker(grid);
                    break;
                }
            }

            // instantiates collision detector
            collisionDetector = new CollisionDetector();

            // move attackers
            for (int i = 0; i < numberOfAttackers; i++) {
                if(attackers[i] != null) {
                    attackers[i].move();
                    collisionDetector.checkBase(attackers[i]);
                }
            }

        }
    }
}
package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;
import org.tworow.towerdefense.Grid.GameplayGrid;
import org.tworow.towerdefense.Projectile.Projectile;

public class Game {

    private GameplayGrid grid;
    private CollisionDetector collisionDetector;
    private int maxNumbersOfAttackers = 5;
    private int maxNumberOfDefenders = 5;
    private Attacker[] attackers;
    private Defender[] defenders;
    private Projectile[] projectiles;

    public Game(int cols, int rows) {

        this.grid = new GameplayGrid(cols, rows);
    }

    public void init() {

        grid.init();
        start();
    }

    public void start() {

        // create empty array of defenders
        defenders = new Defender[maxNumberOfDefenders];

        // defenders test
        defenders[0] = DefenderFactory.createDefender(grid, 2, 0);
        defenders[1] = DefenderFactory.createDefender(grid, 1, 2);

        // create empty array of attackers
        attackers = new Attacker[maxNumbersOfAttackers];

        projectiles = new Projectile[maxNumberOfDefenders];

        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i=0; i < maxNumberOfDefenders; i++) {

                if (defenders[i] != null) {
                    projectiles[i] = defenders[i].shoot();
                }
            }

            for (int i = 0; i < projectiles.length; i++) {
                if (projectiles[i] != null) {
                    projectiles[i].move();
                }
            }

            // instantiate attackers
            for (int i = 0; i < maxNumbersOfAttackers; i++) {

                if(attackers[i] == null) {

                    attackers[i] = AttackerFactory.createAttacker(grid);
                    break;
                }
            }

            // instantiate collision detector
            collisionDetector = new CollisionDetector();

            // move attackers
            for (int i = 0; i < maxNumbersOfAttackers; i++) {

                if(attackers[i] != null) {
                    attackers[i].move();

                    // check if any attacker reached base
                    collisionDetector.checkBase(attackers[i]);
                }
            }

        }
    }
}
package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Attacker.Attackers;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;
import org.tworow.towerdefense.Grid.GameplayGrid;
import org.tworow.towerdefense.Projectile.Projectile;

import java.util.LinkedList;

public class Game {

    private GameplayGrid grid;
    private CollisionDetector collisionDetector;
    private LinkedList<Attacker> attackers;
    private LinkedList<Defender> defenders;
    private LinkedList<Projectile> projectiles;
    private boolean isGameOver;

    public Game(int cols, int rows) {

        this.grid = new GameplayGrid(cols, rows);
    }

    public void init() {

        grid.init();
        start();
    }

    public void start() {

        int counter = 0;

        // create empty array of defenders
        defenders = new LinkedList<>();

        // defenders test (gonna be handled by mouse input)
        defenders.add(DefenderFactory.createDefender(grid, 0, 0, 2));
        defenders.add(DefenderFactory.createDefender(grid, 1, 2, 2));
        defenders.add(DefenderFactory.createDefender(grid, 3, 1, 2));
        defenders.add(DefenderFactory.createDefender(grid, 2, 3, 2));
        defenders.add(DefenderFactory.createDefender(grid, 4, 4, 2));

        // create empty array of attackers
        attackers = new LinkedList<>();

        // create empty array of projectiles
        projectiles = new LinkedList<>();



        // instantiate collision detector
        collisionDetector = new CollisionDetector();

        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;
            // While game is not over, instantiate attackers
            if (counter % 300 == 0) {
                attackers.add(AttackerFactory.createAttacker(grid));
            }
            // Shoot (instantiate projectiles)
            for (int i = 0; i < defenders.size(); i++) {

                if(counter % 300 == 0) {
                projectiles.add(defenders.get(i).shoot());
                }
            }

            // Move projectiles
            for (int i = 0 ; i < projectiles.size(); i++) {
                System.out.println("projectile size" + projectiles.size());
                    projectiles.get(i).move();

                // check if projectile hit an attacker
                for (int j = 0; j < attackers.size(); j++) {
                    System.out.println("attacker size " + attackers.size());
                    if (collisionDetector.checkProjectile(projectiles.get(i), attackers.get(j))) {
                        System.out.println("Vai toma sua gostosa");
                        attackers.get(j).takeDamage(projectiles.get(i).getDamage());
                        projectiles.get(i).getShape().delete();
                        projectiles.remove();
                        i--;

                        if (attackers.get(j).isDead()){
                           attackers.get(j).getShape().delete();
                           attackers.remove();
                           j--;

                        }
                    }
                }

                    if (collisionDetector.checkLimit(projectiles.get(i), grid)) {
                        projectiles.get(i).getShape().delete();
                        projectiles.remove();
                        i--;
                    }

            }







            //Move attackers
            for (int i = 0; i < attackers.size(); i++) {
                System.out.println("attacker size" + attackers.size());
                attackers.get(i).move();

                // check if attacker hit defender
                for (int j = 0; j < defenders.size(); j++) {
                    System.out.println("defender size" + defenders.size());
                    if (collisionDetector.checkDefender(attackers.get(i), defenders.get(j))) {
                        attackers.get(i).stop();

                        if (!defenders.get(j).isDead()) {
                            if (counter % 30 == 0) {
                                defenders.get(j).takeDamage(attackers.get(i).getDamage());
                            }
                            if (defenders.get(j).isDead()) {
                                defenders.get(j).getShape().delete();
                                defenders.remove();
                                j--;
                                attackers.get(i).move();

                            }
                            if (attackers.get(i).isDead()) {
                                attackers.get(i).getShape().delete();
                                attackers.remove();
                                i--;

                            }
                        }
                    }
                }
                if (collisionDetector.checkBase(attackers.get(i))) {
                    attackers.get(i).getShape().delete();
                    attackers.remove();
                    i--;
                    gameOver();
                    System.out.println("Game over");
                }
            }
        }
    }

    public void gameOver() {
        isGameOver = true;
    }


   /* @Override
    public Iterator iterator() {
        current = min;
        return new Iterator() {

            @Override
            public boolean hasNext() {
                return current <= max;
            }

            @Override
            public Integer next() {
                return current++;
            }

            @Override
            public void remove(){

            }
        };
    } */
}

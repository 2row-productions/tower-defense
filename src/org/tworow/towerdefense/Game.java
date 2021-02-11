package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Attacker.Attackers;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;
import org.tworow.towerdefense.Grid.GameplayGrid;
import org.tworow.towerdefense.Projectile.Projectile;

import java.util.Iterator;
import java.util.LinkedList;

public class Game {

    private GameplayGrid grid;
    private CollisionDetector collisionDetector;
    private Attackers attackers;
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
        attackers = new Attackers();

        // create empty array of projectiles
        projectiles = new LinkedList<>();

        Iterator<Attacker> it = attackers.iterator();

        // instantiate collision detector
        collisionDetector = new CollisionDetector();


        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (collisionDetector.checkBase(attackers))

            counter++;
            // While game is not over, instantiate attackers
            if (counter % 300 == 0) {
                attackers.add(AttackerFactory.createAttacker(grid));
            }
            // Shoot (instantiate projectiles)
            for (Defender d : defenders) {
                if(counter % 300 == 0) {
                projectiles.add(d.shoot());
                }
            }

            // Move projectiles
            for (Projectile pr : projectiles) {
                    if (collisionDetector.checkLimit(pr, grid)){
                        //projectiles.iterator().remove();
                        pr.getShape().delete();
                    }
                    pr.move();

                // check if projectile hit an attacker
                for (Attacker a : attackers) {
                    if (collisionDetector.checkProjectile(pr, a)) {
                        System.out.println("Vai toma sua gostosa");
                        //a.takeDamage(pr.getDamage());
                        //pr.setDamage(0);
                        //projectiles.remove(pr);
                        pr.getShape().delete();
                        if (a.isDead()){
                           attackers.remove();
                           a.getShape().delete();

                        }
                    }
                }
            }

            for (Attacker a : attackers) {
                // move attackers
                a.move();

                // check if attacker hit defender
                for (Defender d : defenders) {
                    if (collisionDetector.checkDefender(a, d)) {
                        a.stop();

                        if (!d.isDead()) {
                            if (counter % 30 == 0) {
                                d.takeDamage(a.getDamage());

                            }
                            if (d.isDead()) {
                                defenders.remove(d);
                                d.getShape().delete();
                                a.move();

                            }
                            if (a.isDead()) {
                                attackers.iterator().remove();
                                a.getShape().delete();

                            }
                        }
                    }
                }
                if (collisionDetector.checkBase(a)) {
                    attackers.remove();
                    a.getShape().delete();
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

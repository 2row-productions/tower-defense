package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
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

        // create empty array of defenders
        defenders = new LinkedList<>();

        // defenders test (gonna be handled by mouse input)
        defenders.add(DefenderFactory.createDefender(grid, 2, 0, 2));
        defenders.add(DefenderFactory.createDefender(grid, 1, 2, 2));


        // create empty array of attackers
        attackers = new LinkedList<>();

        // create empty array of projectiles
        projectiles = new LinkedList<>();

        while (true) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //for (Defender d : defenders) {
            //    d.shoot();
            //}

            Projectile p = new Projectile(grid, 0, 0, 2);
            p.move();
            //for (Projectile p : projectiles) {
             //   p.move();
            //}

            // While game is not over, instantiate attackers
            attackers.add(AttackerFactory.createAttacker(grid));

            // instantiate collision detector
            collisionDetector = new CollisionDetector();

            // move attackers
            for (Attacker a : attackers) {

                a.move();

                for (Defender d : defenders) {
                    if (collisionDetector.checkDefender(a, d)) {
                        a.stop();

                        if (!d.isDead()) {
                            d.takeDamage(a.getDamage());
                            System.out.println("DAMAGE!");

                            if (d.isDead()) {
                                defenders.remove(d);
                                d.getShape().delete();
                                a.move();
                            }

                            if (a.isDead()) {
                                attackers.remove(a);
                                a.getShape().delete();
                            }
                        }

                    }

                }


                if (collisionDetector.checkBase(a)) {
                    gameOver();
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

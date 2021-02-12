package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;
import org.tworow.towerdefense.Grid.GameplayGrid;

import java.util.LinkedList;

public class Game {

    private GameplayGrid grid;
    private CollisionDetector collisionDetector;
    private LinkedList<Attacker> attackers;
    private Defender defender;
    private boolean isGameOver;
    private int lifesCounter = 3;

    public Game(int cols, int rows) {

        this.grid = new GameplayGrid(cols, rows);
    }

    public void init() {

        grid.init();
        start();
    }

    public void start() {

        int counter = 0;

        // defenders test (gonna be handled by mouse input)

        defender = DefenderFactory.createDefender(grid, 4, 4);

        // create empty array of attackers
        attackers = new LinkedList<>();


        // Iterator<Attacker> it = attackers.iterator();

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








            //Move attackers
            for (int i = 0; i < attackers.size(); i++) {
                System.out.println("attacker size" + attackers.size());
                attackers.get(i).move();

                // check if attacker hit defender

                if (collisionDetector.checkDefender(a, defender) && !a.getReachedBase()) {

                    a.setReachedBase();

                    if (defender.isDead()) {
                        gameOver();
                    }

                        //attackers.remove();
                        a.getShape().delete();
                }

                if (collisionDetector.checkBase(a) && !a.getReachedBase()) {
                    a.setReachedBase();
                    a.getShape().delete();
                    lifesCounter--;
                    System.out.println(lifesCounter);
                }
            }

            if (lifesCounter == 0) {
                gameOver();
            }
        }
    }

    public void gameOver() {
        isGameOver = true;
    }

}

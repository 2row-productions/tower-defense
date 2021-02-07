package org.tworow.towerdefense.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;

public class GameplayGrid {

    private final static int PADDING = 10;
    private int cols;
    private int rows;
    private int CELL_SIZE = 50;
    private Rectangle grid;
    private int numberOfAttackers = 5;
    private Attacker[] attackers;


    public GameplayGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;

        grid = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        grid.setColor(Color.RED);

    }

    public void init(){
        grid.fill();
        generateCells();

        // Thread.sleep();
        //AttackerFactory.createAttacker(this);
        DefenderFactory.createDefender(this, 2, 0);
        DefenderFactory.createDefender(this, 1, 2);
    }

    public void start() throws InterruptedException {

        attackers = new Attacker[numberOfAttackers];
        while (true) {
            try {
                Thread.sleep(500) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < numberOfAttackers; i++) {
                if(attackers[i] == null) {
                    attackers[i] = AttackerFactory.createAttacker(this);
                    break;

                }
            }
            for (int i = 0; i < numberOfAttackers; i++) {
                if(attackers[i] != null) {
                    attackers[i].move();

                }
            }

        }

    }

    // Create individual cells where characters are instantiated
    public void generateCells() {
        int PADDING2 = PADDING;

        for (int i=0; i<cols; i++){
            for (int j=0; j<rows; j++) {

                new Cell(PADDING2, PADDING + (CELL_SIZE*j), CELL_SIZE, CELL_SIZE, Color.BLACK);
            }

            PADDING2 += CELL_SIZE;
        }
    }

    public void createAttacker() {
        AttackerFactory.createAttacker(this);
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth(){
        return cols * CELL_SIZE;
    }

    public int getHeight(){
        return rows * CELL_SIZE;
    }

    public int getPadding() {
        return PADDING;
    }

    public int getCellsize() {
        return CELL_SIZE;
    }

}

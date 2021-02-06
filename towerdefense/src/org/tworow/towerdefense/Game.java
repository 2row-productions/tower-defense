package org.tworow.towerdefense;

import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class Game {

    private GameplayGrid grid;


    public Game(int cols, int rows){

        this.grid = new GameplayGrid(cols, rows);
        grid.init();

    }

}

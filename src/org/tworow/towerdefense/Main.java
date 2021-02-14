package org.tworow.towerdefense;

public class Main {

    public static void main(String[] args){

       Game towerDefense = new Game(16,7);
       towerDefense.init();

    }
}

/*
Todo list:
- Increases dificulty after a certain number of food
- Game menu with space (or every key) keyhandler event
- Game over
- Possibility of restart game after game over
- Sound
- Different food sprites
- Switch to teleport sprite and moving cells (if its not too complicated)
 */
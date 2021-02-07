package org.tworow.towerdefense;

import org.tworow.towerdefense.Grid.GameplayGrid;

public class Main {

    public static void main(String[] args){

       Game towerDefense = new Game(10,10);
       towerDefense.init();
       towerDefense.start();

    }
}

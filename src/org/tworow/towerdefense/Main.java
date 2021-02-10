package org.tworow.towerdefense;

public class Main {

    public static void main(String[] args){

       Game towerDefense = new Game(10,5);
       towerDefense.init();
       towerDefense.start();

    }
}

// TODO LIST:
// Finish game when enemy reaches base (stop enemies aswell?)
// Projectile
// Get rid of most magic numbers
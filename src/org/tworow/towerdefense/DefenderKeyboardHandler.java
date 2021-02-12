package org.tworow.towerdefense;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.tworow.towerdefense.Character.Attacker.Attacker;

public class KeyboardHandler implements KeyboardHandler {

    private Attacker attacker;


    public KeyboardHandler(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent  ) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                break;
            case KeyboardEvent.KEY_LEFT:
                break;
            case KeyboardEvent.KEY_DOWN:
                break;
            case KeyboardEvent.KEY_UP:
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

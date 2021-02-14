package org.tworow.towerdefense;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Grid.GameplayGrid;

public class PlayerKeyboardHandler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {

    private Movement movement;
    private Game game;

    public PlayerKeyboardHandler(Game game, Defender defender) {
        this.game = game;
        movement = new Movement(defender);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_DOWN:
                movement.moveDown();
                break;
            case KeyboardEvent.KEY_UP:
                movement.moveUp();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

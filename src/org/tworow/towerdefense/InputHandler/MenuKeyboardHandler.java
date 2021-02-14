package org.tworow.towerdefense.InputHandler;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.tworow.towerdefense.GAME_STATE;
import org.tworow.towerdefense.Game;

public class MenuKeyboardHandler implements KeyboardHandler {

    private Game game;

    public MenuKeyboardHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:

                if (game.getState() == GAME_STATE.MENU) {
                    game.setState(GAME_STATE.GAME);
                }

                /*if (game.getState() == GAME_STATE.GAMEOVER) {
                    game.setState(GAME_STATE.GAME);
                }*/

                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

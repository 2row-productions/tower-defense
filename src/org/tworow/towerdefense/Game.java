package org.tworow.towerdefense;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.tworow.towerdefense.Character.Attacker.Attacker;
import org.tworow.towerdefense.Character.Attacker.AttackerFactory;
import org.tworow.towerdefense.Character.Attacker.Enemy;
import org.tworow.towerdefense.Character.Attacker.Food;
import org.tworow.towerdefense.Character.Defender.Defender;
import org.tworow.towerdefense.Character.Defender.DefenderFactory;
import org.tworow.towerdefense.Grid.GameplayGrid;
import org.tworow.towerdefense.InputHandler.MenuKeyboardHandler;
import org.tworow.towerdefense.InputHandler.PlayerKeyboardHandler;

import java.util.LinkedList;

public class Game {

    private GameplayGrid grid;
    private CollisionDetector collisionDetector;
    private LinkedList<Attacker> attackers;
    private Defender defender;
    private MenuKeyboardHandler menuKeyboardHandler;
    private PlayerKeyboardHandler playerKeyboardHandler;
    private Keyboard keyboard;
    private KeyboardEvent keyboardEvent;
    private KeyboardEventType keyboardEventType;
    private boolean isGameOver;
    private boolean shouldIncreaseDiff = true;
    private int score = 0;
    private int lifesCounter = 3;
    private int levelOfDifficulty = 400;
    private Text scoreText;
    private GAME_STATE state = GAME_STATE.MENU;
    private Picture menuBackground;
    private Sound backgroundSound;
    private Sound lifeLossSound;
    private Sound gameOverSound;
    private Sound eatingSound;
    private Sound enemyHitSound;
    private Sound difficultyIncreaseSound;
    private Picture[] lifesImgArray;

    public Game(int cols, int rows) {

        this.grid = new GameplayGrid(cols, rows);
    }

    public void setState(GAME_STATE state) {
        this.state = state;
    }

    public GAME_STATE getState(){
        return state;
    }

    public void init() {

        menuKeyboardHandler = new MenuKeyboardHandler(this);
        keyboard = new Keyboard(menuKeyboardHandler);
        keyboardEvent = new KeyboardEvent();
        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

        int counter = 0;
        backgroundSound = new Sound("/resources/sounds/dbz-opening.wav");
        backgroundSound.play(true);

        while (true) {

            if (state == GAME_STATE.MENU) {

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
                menuBackground = new Picture(grid.getPadding(), grid.getPadding(), "resources/menu/startMenu/start-menu-without-instructions.png");
                menuBackground.draw();

                if (counter > 2) {
                    counter = 0;
                    menuBackground = new Picture(grid.getPadding(), grid.getPadding(), "resources/menu/startMenu/start-menu-w-instruction.png");
                    menuBackground.draw();
                }
            }

            if (state == GAME_STATE.GAME) {
                menuBackground.delete();
                grid.init();
                start();
            }

            if (state == GAME_STATE.GAMEOVER){
                grid.deleteGrid();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                counter++;
                menuBackground = new Picture(grid.getPadding(), grid.getPadding(), "resources/menu/gameOverMenu/game-over-1.png");
                menuBackground.draw();

                scoreText = new Text(grid.getWidth() - 105, grid.getHeight()+130   , "Score: " + score);
                scoreText.grow(40, 40);
                scoreText.setColor(Color.WHITE);

                if (counter > 2) {
                    counter = 0;
                    menuBackground = new Picture(grid.getPadding(), grid.getPadding(), "resources/menu/gameOverMenu/game-over-2.png");
                    menuBackground.draw();
                    scoreText.draw();
                }


            }

            if(state == GAME_STATE.MARYGAMEOVER){
                menuBackground.delete();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                counter++;
                menuBackground = new Picture(grid.getPadding(), grid.getPadding(), "resources/menu/gameOverMenu/mary-over-1.png");
                menuBackground.draw();


                if (counter > 2) {
                    counter = 0;
                    menuBackground = new Picture(grid.getPadding(), grid.getPadding(), "resources/menu/gameOverMenu/mary-over-2.png");
                    menuBackground.draw();
                }

            }
        }

    }

    public void start() {

        lifesImgArray = new Picture[]{
                new Picture(grid.getPadding()+120, grid.getHeight()+90, "resources/lives/life-sprite.png"),
                new Picture(grid.getPadding()+150, grid.getHeight()+90, "resources/lives/life-sprite.png"),
                new Picture(grid.getPadding()+180, grid.getHeight()+90, "resources/lives/life-sprite.png"),
        };

        for (Picture img : lifesImgArray) {
            img.draw();
        }

        scoreText = new Text(grid.getPadding()+128, grid.getHeight()+150, "" + score);
        scoreText.setColor(Color.WHITE);
        scoreText.grow(7, 15);
        scoreText.draw();

        int counter = 0;

        // instantiate defender
        defender = DefenderFactory.createDefender(grid, 1, 0);

        // instantiate defender keyboardHandler and listeners
        playerKeyboardHandler = new PlayerKeyboardHandler(this, defender);
        keyboard = new Keyboard(playerKeyboardHandler);
        keyboardEvent = new KeyboardEvent();
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);

        // create empty array of attackers
        attackers = new LinkedList<>();

        // instantiate collision detector
        collisionDetector = new CollisionDetector();

        while (!isGameOver) {

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;

            // While game is not over, instantiate attackers
            if (counter % levelOfDifficulty == 0) {
                attackers.add(AttackerFactory.createAttacker(grid));
            }

            //Move attackers
            for (int i = 0; i < attackers.size(); i++) {

                Attacker attacker = attackers.get(i);

                attacker.move();

                // check if attacker hit defender
                if (collisionDetector.checkDefender(attacker, defender) && !attacker.getReachedBase()) {

                    if (attacker instanceof Enemy && !attacker.isAlreadyHit()){
                        enemyHitSound = new Sound("/resources/sounds/caralho.wav");
                        enemyHitSound.play(true);

                        defender.setHit(true);
                        lifesCounter--;
                        if (lifesCounter == 2) {
                            lifesImgArray[2].delete();
                        } else if (lifesCounter == 1) {
                            lifesImgArray[1].delete();
                        }

                        defender.setEating(false);

                        // switches buu sprite
                        defender.getShape().delete();
                        defender.setShape(new Picture(defender.getCol(), defender.getRow(), "resources/buu/buu-hit.png"));
                        defender.getShape().draw();

                        attacker.setAlreadyHit(true);
                        attacker.getShape().delete();

                    } else if (attacker instanceof Food) {
                        shouldIncreaseDiff = true;

                        eatingSound = new Sound("/resources/sounds/eating-sound.wav");
                        eatingSound.play(true);
                        defender.setEating(true);

                        // switches buu sprite
                        defender.getShape().delete();
                        defender.setShape(new Picture(defender.getCol(), defender.getRow(), "resources/buu/buu-eating.png"));
                        defender.getShape().draw();

                        attacker.setReachedBase();
                        attacker.getShape().delete();
                        score += 100;
                        scoreText.setText("" + score);
                    }

                }

                if (collisionDetector.checkBase(attacker) && !attacker.getReachedBase()) {

                    attacker.setReachedBase();
                    attacker.getShape().delete();
                    lifesCounter--;

                    if (lifesCounter == 2) {

                        lifesImgArray[2].delete();
                    } else if (lifesCounter == 1) {

                        lifesImgArray[1].delete();
                    }

                    lifeLossSound = new Sound("/resources/sounds/fodasse.wav");
                    lifeLossSound.play(true);
                }
            }
            if (defender.isHit() && counter % 65 == 0) {

                defender.setHit(false);

                defender.getShape().delete();
                defender.setShape(new Picture(defender.getCol(), defender.getRow(), "resources/buu/buu.png"));
                defender.getShape().draw();
            }

            if (defender.isEating() && counter % 65 == 0) {

                defender.setEating(false);

                defender.getShape().delete();
                defender.setShape(new Picture(defender.getCol(), defender.getRow(), "resources/buu/buu.png"));
                defender.getShape().draw();

            }

            if (defender.isTeleporting() && counter % 40 == 0) {

                defender.setTeleporting(false);

                defender.getShape().delete();
                defender.setShape(new Picture(defender.getCol(), defender.getRow(), "resources/buu/buu.png"));
                defender.getShape().draw();
            }

            if (score % 500 == 0 && score != 0 && shouldIncreaseDiff) {
                difficultyIncreaseSound = new Sound("/resources/sounds/a-true-miracle.wav");
                difficultyIncreaseSound.play(true);

                if (levelOfDifficulty > 100) {
                    levelOfDifficulty -= 50;
                }
                shouldIncreaseDiff = false;
            }


            if (lifesCounter == 0) {
                gameOver();
            }
        }
    }

    public void gameOver() {
        isGameOver = true;
        setState(GAME_STATE.GAMEOVER);
        backgroundSound.stop();
        gameOverSound = new Sound("/resources/sounds/olha-bem.wav");
        gameOverSound.play(true);
    }

}

package controller;

import model.*;

import java.awt.event.*;

public class GameController{
    protected int levelNum;
    protected Level level;
    protected LevelScreenInterface game;
    protected GameFrameInterface mainFrame;
    protected MainController main;
    protected HomePanelInterface homeScreen;

    protected int sendPost;
    protected int receivePost;
    protected volatile boolean moving = false;

    protected ActionListener menuListener;
    protected ActionListener resetListener;

    protected volatile boolean click = false;
    protected boolean playAgain = false;
    protected boolean next = false;
    protected boolean exit = false;

    protected ActionListener leftSend;
    protected ActionListener midSend;
    protected ActionListener rightSend;
    protected ActionListener leftReceive;
    protected ActionListener midReceive;
    protected ActionListener rightReceive;

    public GameController(GameFrameInterface mainFrame, MainController main, Level level, LevelScreenInterface game) {
        this.mainFrame = mainFrame;
        this.main = main;
        this.homeScreen = main.getHomeScreen();
        this.level = level;
        this.levelNum = level.getLevel();
        this.game = game;

        // setting up control panel action listeners
        menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println("menu clicked");
                click = true;
                exit = true;
            }
        };

        resetListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game was reset.");
                click = true;
                restartLevel();
            }
        };

        // setting up post action listeners
        leftSend = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println("left post send");
                moving = true;
                sendPost = 0;
            }
        };

        midSend = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println("mid post send");
                moving = true;
                sendPost = 1;
            }
        };

        rightSend = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println("right post send");
                moving = true;
                sendPost = 2;
            }
        };

        leftReceive = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println("left post receive");
                moving = false;
                receivePost = 0;
            }
        };

        midReceive = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println("mid post receive");
                moving = false;
                receivePost = 1;
            }
        };

       rightReceive = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println("right post receive");
                moving = false;
                receivePost = 2;
            }
        };

       // adding action listeners to control panel
        this.game.setOnMenu(menuListener);
        this.game.setOnReset(resetListener);
    }

    // exits level screen and shows home panel
    private void exitToMenu() {
        this.mainFrame.swapMainPanel(this.homeScreen.getHomePanel());
        this.main.setInMenu(true);
    }

    // user plays
    public void play() {
        System.out.println("[playing]");

        // user plays until level is complete
        while (!level.isEnd()) {
            // ends game play if control panel button is clicked
            if (click == true) {
                click = false;
                if (exit == true) {
                    System.out.println("exiting...");
                    exitToMenu();
                }
                return;
            }
            // player can move rings
            else {
                this.moveRing();
            }
        }
        System.out.println("LEVEL COMPLETE");

        // disables control panel buttons when level is complete
        this.game.disableMenu();
        this.game.disableReset();

        // shows dialog box indicating level is complete
        this.game.levelComplete(this.levelNum, this.level.getMoveCounter());
        endGame();
    }

    // sets up choices in dialog box when game is completed
    private void endGame() {
        System.out.println(this.game.getBestScore());
        this.main.endOfLevelUpdates(this.game.getBestScore());

        System.out.println("Scores were updated");
        ActionListener nextListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next = true;
            }
        };

        this.game.setOnMenuComplete(menuListener);
        this.game.setOnPlayAgain(resetListener);
        this.game.setOnNextLevel(nextListener);

        while (this.game.endChoice() == false);

        if (playAgain == true) {
            playAgain = false;
        } else if (exit == true) {
            exitToMenu();
        } else if (next == true) {
            this.levelNum += 1;
            this.level = new Level(this.levelNum);
            next = false;
            restartLevel();
        }
    }

    // user input to move rings
    private void moveRing() {

        this.game.setOnLeft(leftSend);
        this.game.setOnMid(midSend);
        this.game.setOnRight(rightSend);

        // waiting for send post to be chosen
        while(moving == false) {
            if (click == true) {
                break;
            }
        }

        this.game.removeOnLeft(leftSend);
        this.game.removeOnMid(midSend);
        this.game.removeOnRight(rightSend);

        this.game.setOnLeft(leftReceive);
        this.game.setOnMid(midReceive);
        this.game.setOnRight(rightReceive);

        // waiting for receiving post to be chosen or control panel button is clicked
        while(moving == true) {
            if (click == true) {
                // exiting mid move
                moving = false;
                break;
            }
        }

        this.game.removeOnLeft(leftReceive);
        this.game.removeOnMid(midReceive);
        this.game.removeOnRight(rightReceive);

        if (click == true) {
            // exiting move
            return;
        } else if (this.level.move(sendPost, receivePost)) {
            this.game.updateMoves(this.level.getMoveCounter());
            this.game.moveRingIcon(sendPost, receivePost);
        } else {
            this.game.invalidMove();
        }

    }

    // restart level from beginning
    public void restartLevel() {
        this.level.reset();
        this.game.updateMoves(this.level.getMoveCounter());

        this.game.enableMenu();
        this.game.enableReset();

        this.game.buildGame(level);
    }
}

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
    protected ActionListener changeListener;
    protected boolean restarted = false;
    protected boolean playAgain = false;
    protected boolean next = false;

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

        menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("menu clicked");
                exitToMenu();

            }
        };

        resetListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("reset clicked");
                restarted = true;
                restartLevel();
                play();
            }
        };

//        changeListener = new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("change level clicked");
//                // change level dialogue
//            }
//        };

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

        this.game.setOnMenu(menuListener);
        this.game.setOnReset(resetListener);
//        this.game.setOnLevel(changeListener);
    }

    private void exitToMenu() {
        System.out.println("trying to exit");
        this.mainFrame.swapMainPanel(this.homeScreen.getHomePanel());

//        while(!this.main.getLevelChosen());

//        this.main.startGame();
        System.out.println("swapped");
    }

    // user plays
    public void play() {
        System.out.println("playing");
        while (!level.isEnd()) {
            System.out.println("Moves: " + level.getMoveCounter());
            if (restarted == true) {
                System.out.println("restarting");
                restarted = false;
                return;
            }
            this.moveRing();
        }
        System.out.println("LEVEL COMPLETE");

        this.game.disableMenu();
        this.game.disableReset();
        this.game.levelComplete();
        endGame();
    }

    // choices in dialog box when game is completed
    private void endGame() {
        ActionListener replayListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("replaying");
                restarted = false;
                playAgain = true;
                restartLevel();
                System.out.println("restarted");
            }
        };

        ActionListener nextListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next = true;
            }
        };

        this.game.setOnMenuComplete(menuListener);
        this.game.setOnPlayAgain(replayListener);
        this.game.setOnNextLevel(nextListener);
        // if high score
        // else

        while (this.game.endChoice() == false);

        if (playAgain == true) {
            playAgain = false;
            play();
        }

        if (next == true) {
            this.levelNum += 1;
            this.level = new Level(this.levelNum);
            next = false;

            restartLevel();
            play();
        }
    }


    // user input to move rings
    private void moveRing() {

        this.game.setOnLeft(leftSend);
        this.game.setOnMid(midSend);
        this.game.setOnRight(rightSend);

        while(moving == false);

        this.game.removeOnLeft(leftSend);
        this.game.removeOnMid(midSend);
        this.game.removeOnRight(rightSend);

        this.game.setOnLeft(leftReceive);
        this.game.setOnMid(midReceive);
        this.game.setOnRight(rightReceive);

        while(moving == true);

        this.game.removeOnLeft(leftReceive);
        this.game.removeOnMid(midReceive);
        this.game.removeOnRight(rightReceive);

        if (this.level.move(sendPost, receivePost)) {
            this.game.updateMoves(this.level.getMoveCounter());
            this.game.moveRingIcon(sendPost, receivePost);
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

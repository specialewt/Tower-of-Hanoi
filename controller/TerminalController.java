package controller;

import model.*;

import java.util.Scanner;

public class TerminalController {
    private int levelNum;
    private Scanner s;
    private String[] game;
    private Level level;
    private int maxRings;

    public TerminalController() {
        System.out.println("Towers of Hanoi");
        s = new Scanner(System.in);

        this.selectLevel();
        this.buildGame();
    }

    // creating proper level state for initialization & changing level
    public void selectLevel() {
        System.out.println("Select level 1, 2, or 3:");

        this.levelNum = Integer.parseInt(s.nextLine());
        this.level = new Level(levelNum);
        this.maxRings = level.getMaxRings();
        this.buildGame();
    }

    // use case: user plays by moving rings
    public void play() {
        while (!level.isEnd()) {
            System.out.println("Moves: " + level.getMoveCounter());
            this.moveRing();
            System.out.println(this);
        }
        System.out.println("LEVEL COMPLETE");
    }

    // user input to move rings
    private void moveRing() {
        System.out.println("Choose sending post (1, 2, or 3): ");
        int sendingPost = Integer.parseInt(s.nextLine()) - 1;

        System.out.println("Choose receiving post(1, 2, or 3): ");
        int receivingPost = Integer.parseInt(s.nextLine()) - 1;

        if (this.level.move(sendingPost, receivingPost)) {
            this.buildGame();
        }
    }

    // resets game state
    public void restartLevel() {
        this.level.reset();
        System.out.println("Moves: " + this.level.getMoveCounter() + "\n");
        this.buildGame();
    }

    // not yet implemented (not needed for terminal version)
    public void quitLevel() {
        System.out.println("Quit to menu");
    }

    // building user interface in terminal
    private String[] buildPost(Post p) {
        String post[] = new String[6];
        Object[] rings = p.getRings().toArray();

        post[0] = "      _ ";
        for (int i = 1; i < (post.length - rings.length); i++) {
            post[i] = "     | |";
            if (i == 5) {
                post[5] = "_____| |";
            }
        }
        for (int j = post.length; j > (post.length - rings.length); j--) {
            int ringLen = rings[post.length - j].toString().length();
            char buffer[] = new char[8 - ringLen];
            for (int k = 0; k < buffer.length; k++){
                if (j == 6) {
                    buffer[k] = '_';
                } else {
                    buffer[k] = ' ';
                }
            }

            post[j - 1] = String.valueOf(buffer) + rings[post.length - j].toString();
        }

        return post;
    }

    private String[] buildGame() {

        String[] left = this.buildPost(level.getPost(0));
        String[] center = this.buildPost(level.getPost(1));
        String[] right = this.buildPost(level.getPost(2));

        game = new String[6];
        for (int i = 0; i < game.length; i++) {
            game[i] = left[i] + center[i] + right[i];
            if (i == 5) {
                game[i] += "_____";
            }
        }

        return game;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < game.length; i++) {
            s += game[i] + "\n";
        }

        return s;
    }
}

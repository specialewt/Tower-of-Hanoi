package controller;

import model.*;

import java.util.Scanner;

public class TerminalController {
    private int levelNum;
    private Scanner s;
    private String[] game;
    private Level level;
    private int maxRings;
    private boolean end;

    public TerminalController() {
        System.out.println("Towers of Hanoi");
        s = new Scanner(System.in);

        this.selectLevel();
        this.maxRings = level.getMaxRings();

        this.end = false;
        this.buildGame();
    }

    // for initializing
    public void selectLevel() {
        System.out.println("Select level 1, 2, or 3:");

        levelNum = Integer.parseInt(s.nextLine());
        this.changeLevel(levelNum);
    }

    // for switching level
    public void changeLevel(int newLevel) {
        level = new Level(levelNum);
        this.buildGame();
    }

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

    public void moveBlock() {
        System.out.println("Choose sending post (1, 2, or 3): ");
        int sendingPost = Integer.parseInt(s.nextLine()) - 1;

        System.out.println("Choose receiving post(1, 2, or 3): ");
        int receivingPost = Integer.parseInt(s.nextLine()) - 1;

        if (this.level.move(sendingPost, receivingPost)) {
            System.out.println("Moves: " + level.getMoveCounter());
            this.buildGame();
        }
    }


    public boolean isEnd() {
        // move to Level class
        if (level.getPost(2).isComplete(maxRings)) {
            this.end = true;
        }
        return end;
    }

    public void restartLevel() {
        this.level.reset();
        this.end = false;
        this.buildGame();
    }

    public void quitLevel() {

    }

    public String toString() {
        String s = "";
        for (int i = 0; i < game.length; i++) {
//            for (int j = 0; j < game[i].length; j++) {
//                s += game[i][j];
//            }

            s += game[i] + "\n";
        }

        return s;
    }
}

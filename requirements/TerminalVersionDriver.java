import model.*;
import controller.*;

import java.util.Scanner;

public class TerminalVersionDriver {

    public static void main(String args[]){

        TerminalController game = new TerminalController();
        System.out.println(game);

        while(true) {
//            System.out.println(game.isEnd());

            while (!game.isEnd()) {
                game.moveBlock();
                System.out.println(game);
            }

            System.out.println("LEVEL COMPLETE");

            Scanner s = new Scanner(System.in);
            System.out.println("Choose from the following:\n (1) Play again\n (2) Change Level\n (3) Quit");

            int choice = Integer.parseInt(s.nextLine());
            if (choice == 1) {
                game.restartLevel();
                System.out.println(game);
            } else if (choice == 2) {
                game.selectLevel();
                int newLevel = Integer.parseInt(s.nextLine());
                game.changeLevel(newLevel);
                System.out.println(game);
            } else if (choice == 3) {
                System.exit(0);
            }
        }
    }
}

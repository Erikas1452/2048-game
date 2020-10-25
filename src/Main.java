import javafx.scene.Parent;

import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Boolean gameOver = false;
        Board defaultBoard = new Board(4);
        GameLogic.generateRandomTile(defaultBoard);
        GameLogic.generateRandomTile(defaultBoard);

        while (!gameOver)
        {

            if(GameLogic.gameWon(defaultBoard))
            {
                defaultBoard.displayMap();
                System.out.println("YOU WIN");
                gameOver = true;
                break;
            }

            if(!GameLogic.canMoveSomewhere(defaultBoard))
            {
                gameOver = true;
                defaultBoard.displayMap();
                System.out.println("GAME OVER");
                break;
            }

            System.out.println("Use A(left) W(up) S(down) D(right) to move tiles");

            Scanner scanner = new Scanner(System.in);

            Boolean input = false;

            while(input == false) {

                defaultBoard.displayMap();

                char move = scanner.next().charAt(0);

                switch (Character.toUpperCase(move)) {
                    case 'W':
                        System.out.println("UP");
                        input = true;
                        GameLogic.moveTiles(defaultBoard,'W');
                        break;
                    case 'S':
                        System.out.println("DOWN");
                        input = true;
                        GameLogic.moveTiles(defaultBoard,'S');
                        break;
                    case 'A':
                        System.out.println("LEFT");
                        input = true;
                        GameLogic.moveTiles(defaultBoard,'A');
                        break;
                    case 'D':
                        System.out.println("RIGHT");
                        input = true;
                        GameLogic.moveTiles(defaultBoard,'D');
                        break;
                }
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}

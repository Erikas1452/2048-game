import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.scene.Parent;

import javax.swing.text.StyledEditorKit;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Boolean gameOver = false;
        Board defaultBoard = new Board(4);
        GameLogic.generateRandomTile(defaultBoard);
        GameLogic.generateRandomTile(defaultBoard);
        boolean undo = false;
        Board prevMove = new Board(4);


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
                        input = true;
                        undo = GameLogic.moveTiles(defaultBoard,'W',prevMove,undo);
                        break;
                    case 'S':
                        input = true;
                        undo = GameLogic.moveTiles(defaultBoard,'S',prevMove,undo);
                        break;
                    case 'A':
                        input = true;
                        undo = GameLogic.moveTiles(defaultBoard,'A',prevMove,undo);
                        break;
                    case 'D':
                        input = true;
                        undo = GameLogic.moveTiles(defaultBoard,'D',prevMove,undo);
                        break;
                    case 'U':
                        input = true;
                        if(undo == true)
                        {
                            System.out.println("UNDOING MOVE");
                            GameLogic.undoMove(defaultBoard,prevMove);
                            undo = false;
                        }
                        else System.out.println("Cant undo your move now");
                        break;
                }
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

}

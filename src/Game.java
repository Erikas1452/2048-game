import java.util.Scanner;

public class Game {

    private static final Game INSTANCE = new Game(4);

    private boolean gameOver;
    private int boardSize;
    private Board defaultBoard;
    private Board prevMove;
    boolean undo;

    public Game(int boardSize) {
        this.gameOver = false;
        this.boardSize = boardSize;
        this.defaultBoard = new Board(boardSize);
        this.prevMove = new Board(boardSize);
        this.undo = false;
    }

    public void startGame()
    {
        Board defaultBoard = new Board(4);
        BoardLogic.generateRandomTile(defaultBoard);
        BoardLogic.generateRandomTile(defaultBoard);

        while (!gameOver)
        {
            if(BoardLogic.gameWon(defaultBoard))
            {
                defaultBoard.displayMap();
                System.out.println("YOU WIN");
                gameOver = true;
                break;
            }

            if(!BoardLogic.canMoveSomewhere(defaultBoard))
            {
                gameOver = true;
                defaultBoard.displayMap();
                System.out.println("GAME OVER");
                break;
            }

            System.out.println("Use A(left) W(up) S(down) D(right) to move tiles U (undo)");

            Scanner scanner = new Scanner(System.in);

            Boolean input = false;
            while(input == false) {
                defaultBoard.displayMap();

                MovementController controller = new MovementController(input,undo,defaultBoard,prevMove);

                char move = scanner.next().charAt(0);
                move = Character.toUpperCase(move);

                controller.execute(move);

                input = controller.inputStatus();
                undo = controller.undoStatus();
            }
        }
    }

    public static Game getInstance()
    {
        return INSTANCE;
    }
}

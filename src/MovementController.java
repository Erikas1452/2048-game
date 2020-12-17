public class MovementController implements CommandController{

    public static final char MOVE_UP='W';
    public static final char MOVE_DOWN='S';
    public static final char MOVE_LEFT='A';
    public static final char MOVE_RIGHT='D';
    public static final char UNDO='U';

    private boolean input;
    private boolean undo;
    private Board gameBoard;
    private Board prevMove;

    public MovementController(boolean input, boolean undo, Board gameBoard, Board prevMove) {
        this.input = input;
        this.undo = undo;
        this.gameBoard = gameBoard;
        this.prevMove = prevMove;
    }

    @Override
    public void execute(char command) {
        switch (command) {
            case MOVE_UP:
                input = true;
                MoveUp upCommand = new MoveUp(gameBoard,prevMove);
                undo = upCommand.execute();
                break;
            case MOVE_DOWN:
                input = true;
                MoveDown downCommand = new MoveDown(gameBoard,prevMove);
                undo = downCommand.execute();
                break;
            case MOVE_LEFT:
                input = true;
                MoveLeft leftCommand = new MoveLeft(gameBoard,prevMove);
                undo = leftCommand.execute();
                break;
            case MOVE_RIGHT:
                input = true;
                MoveRight rightCommand = new MoveRight(gameBoard,prevMove);
                undo = rightCommand.execute();
                break;
            case UNDO:
                input = true;
                if(undo == true)
                {
                    System.out.println("UNDOING MOVE");
                    UndoMove undoMove = new UndoMove(gameBoard,prevMove);
                    undo = undoMove.execute();
                }
                else System.out.println("Cant undo your move now");
                break;
        }
    }

    @Override
    public boolean canHandle(char command) {
        if(command == MOVE_UP||
        command == MOVE_DOWN||
        command == MOVE_LEFT||
        command == MOVE_RIGHT||
        command == UNDO) return true;
        else return false;
    }

    public boolean inputStatus() {
        return input;
    }

    public boolean undoStatus() {
        return undo;
    }
}

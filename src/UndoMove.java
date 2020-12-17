public class UndoMove implements Command{

    private Board gameBoard;
    private Board prevMove;

    public UndoMove(Board gameBoard, Board prevMove) {
        this.gameBoard = gameBoard;
        this.prevMove = prevMove;
    }

    @Override
    public boolean execute() {
        gameBoard.setTiles(prevMove.getTiles());
        return false;
    }
}

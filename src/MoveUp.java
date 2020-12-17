public class MoveUp implements Command{

    private Board gameBoard;
    private Board prevMove;

    public MoveUp(Board gameBoard, Board prevMove) {
        this.gameBoard = gameBoard;
        this.prevMove = prevMove;
    }

    @Override
    public boolean execute() {
        Board copy = gameBoard.copyBoard();

        Tile allTiles [][] = gameBoard.getTiles();
        Tile original [][] = copy.getTiles();

        for (int column = 0; column < gameBoard.getSize(); column++) {
            moveUP(column, gameBoard.getSize(), allTiles);
        }
        boolean undo = BoardLogic.updateBoards(gameBoard,prevMove,original,allTiles);
        return undo;
    }

    private static void moveUP(int column, int size, Tile tiles[][])
    {

        for(int row = 0; row < size; row++)
        {
            for(int rows = row; rows >= 0; rows--)
            {
                if(rows-1 != -1 && (tiles[rows-1][column].getValue() == 0))
                {
                    tiles[rows-1][column].setValue(tiles[rows][column].getValue());
                    tiles[rows][column].setValue(0);
                }
                else if (rows-1 != -1 && tiles[rows-1][column].tilesAreEquel(tiles[rows][column]))
                {
                    tiles[rows-1][column].merge(tiles[rows][column]);
                    break;
                }
                else break;
            }
        }
    }
}

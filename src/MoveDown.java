public class MoveDown implements Command{

    private Board gameBoard;
    private Board prevMove;

    public MoveDown(Board gameBoard, Board prevMove) {
        this.gameBoard = gameBoard;
        this.prevMove = prevMove;
    }

    @Override
    public boolean execute() {
        return moveColumns();
    }

    private boolean moveColumns()
    {
        Board copy = gameBoard.copyBoard();

        Tile allTiles [][] = gameBoard.getTiles();
        Tile original [][] = copy.getTiles();

        for (int column = 0; column < gameBoard.getSize(); column++) {
            moveDown(column, gameBoard.getSize(), allTiles);
        }
        boolean undo = BoardLogic.updateBoards(gameBoard,prevMove,original,allTiles);
        return undo;
    }

    private void moveDown(int column, int size, Tile tiles[][])
    {

        for(int row = size-1; row >= 0; row--)
        {
            for(int rows = row; rows < size; rows++)
            {
                if(rows+1 != size && (tiles[rows+1][column].getValue() == 0))
                {
                    tiles[rows+1][column].setValue(tiles[rows][column].getValue());
                    tiles[rows][column].setValue(0);
                }
                else if (rows+1 != size && tiles[rows+1][column].tilesAreEquel(tiles[rows][column]))
                {
                    tiles[rows+1][column].merge(tiles[rows][column]);
                    break;
                }
                else break;
            }
        }
    }
}

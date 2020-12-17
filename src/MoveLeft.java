public class MoveLeft implements Command{

    private Board gameBoard;
    private Board prevMove;

    public MoveLeft(Board gameBoard, Board prevMove) {
        this.gameBoard = gameBoard;
        this.prevMove = prevMove;
    }

    @Override
    public boolean execute() {
        Board copy = gameBoard.copyBoard();

        Tile allTiles [][] = gameBoard.getTiles();
        Tile original [][] = copy.getTiles();

        for (int row = 0; row < gameBoard.getSize(); row++) {
            moveLeft(row, gameBoard.getSize(), allTiles);
        }

        boolean undo = false;

        if(BoardLogic.isChanged(original,allTiles, gameBoard.getSize()))
        {
            gameBoard.setTiles(allTiles);
            BoardLogic.generateRandomTile(gameBoard);
            prevMove.setTiles(original);

            undo = true;
            return undo;
        }
        else
        {
            gameBoard.setTiles(original);
            System.out.println("Can't Move anything this direction");

            undo = false;
            return undo;
        }
    }

    private void moveLeft(int row, int size, Tile tiles[][])
    {
        for(int column = 0; column < size; column++)
        {
            for(int columns = column; columns >= 0; columns--)
            {
                if(columns-1 != -1 && (tiles[row][columns-1].getValue() == 0))
                {
                    tiles[row][columns-1].setValue(tiles[row][columns].getValue());
                    tiles[row][columns].setValue(0);
                }
                else if (columns-1 != -1 && tiles[row][columns-1].tilesAreEquel(tiles[row][columns]))
                {
                    tiles[row][columns-1].merge(tiles[row][columns]);
                    break;
                }
                else break;
            }
        }
    }
}

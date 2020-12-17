import com.sun.xml.internal.ws.resources.ModelerMessages;

import java.util.ArrayList;

public class BoardLogic {

    public static void generateRandomTile(Board gameBoard)
    {
        Tile newTile = TileGenerator.generateNewTile();

        gameBoard.findEmptyTiles();
        ArrayList<Tile> emptyTiles = gameBoard.getEmptyTiles();

        int location = TileGenerator.generateLocation(emptyTiles);

        emptyTiles.get(location).setValue(newTile.getValue());

    }

    static boolean isChanged(Tile original[][], Tile newBoard[][], int size)
    {
        for (int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(original[i][j].getValue() != newBoard[i][j].getValue()) return true;
            }
        }
        return false;
    }

    public static boolean gameWon(Board gameBoard)
    {
        Tile allTiles [][] = gameBoard.getTiles();

        for(int i = 0; i < gameBoard.getSize(); i++)
        {
            for(int j = 0; j < gameBoard.getSize(); j++)
            {
                if(allTiles[i][j].getValue() == 2048) return true;
            }
        }
        return false;
    }

    public static boolean canMoveSomewhere(Board gameBoard)
    {
        Board copy = gameBoard.copyBoard();
        Board prevMove = new Board(gameBoard.getSize());

        Tile allTiles [][] = copy.getTiles();
        Tile original [][] = gameBoard.getTiles();

        MoveLeft leftCommand = new MoveLeft(copy,prevMove);

        if(leftCommand.execute()) return true;

        MoveUp upCommand = new MoveUp(copy,prevMove);

        if(upCommand.execute()) return true;

        MoveDown downCommand = new MoveDown(copy,prevMove);

        if(downCommand.execute()) return true;

        MoveRight moveRight = new MoveRight(copy,prevMove);

        if(moveRight.execute()) return true;

        copy.displayMap();

        return false;

    }

    public static boolean updateBoards(Board gameBoard, Board prevMove, Tile[][] original, Tile[][]allTiles)
    {
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

            undo = true;
            return undo;
        }
    }

}

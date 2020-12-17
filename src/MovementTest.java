import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    @Test
    void undoTests()
    {
        Board gameBoard = new Board(3);
        Board prevMove = new Board(3);

        Tile tiles[][] = gameBoard.getTiles();
        tiles[2][0].setValue(2);

        Tile oldTiles[][] = gameBoard.copyBoard().getTiles();

        MoveUp upCommand = new MoveUp(gameBoard,prevMove);
        upCommand.execute();

        tiles = gameBoard.getTiles();
        boolean changed = BoardLogic.isChanged(oldTiles,tiles,3);
        assertTrue(changed);

        UndoMove undoCommand = new UndoMove(gameBoard,prevMove);
        undoCommand.execute();

        tiles = gameBoard.getTiles();
        changed = BoardLogic.isChanged(oldTiles,tiles,3);
        assertFalse(changed);
    }

    @Test
    void moveUp()
    {
        Board gameBoard = new Board(3);
        Board prevMove = new Board(3);

        Tile tiles[][] = gameBoard.getTiles();
        tiles[2][0].setValue(2);

        MoveUp upCommand = new MoveUp(gameBoard,prevMove);
        upCommand.execute();

        tiles = gameBoard.getTiles();

        boolean result;
        if(tiles[0][0].getValue() == 2)result = true;
        else result = false;

        int countOfZeroes = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(tiles[i][j].getValue() == 0) countOfZeroes++;
            }
        }
        assertTrue(result);
        assertEquals(7,countOfZeroes);
    }

}
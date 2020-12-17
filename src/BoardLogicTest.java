import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardLogicTest {

    @Test
    void gameOverTests()
    {
        Board gameBoard = new Board(4);

        Tile tiles [][] = gameBoard.getTiles();
        tiles[0][0].setValue(2048);

        gameBoard.setTiles(tiles);

        boolean result = BoardLogic.gameWon(gameBoard);

        assertTrue(result);
    }

    @Test
    void cantMoveAnywhere()
    {
        Board gameBoard = new Board(2);

        Tile tiles [][] = gameBoard.getTiles();
        tiles[0][0].setValue(2); tiles[0][1].setValue(4);
        tiles[1][0].setValue(4); tiles[1][1].setValue(2);

        gameBoard.setTiles(tiles);

        boolean result = BoardLogic.canMoveSomewhere(gameBoard);

        assertFalse(result);
    }

    @Test
    void canMoveSomewhere()
    {
        Board gameBoard = new Board(2);

        Tile tiles [][] = gameBoard.getTiles();
        tiles[0][0].setValue(2); tiles[0][1].setValue(4);
        tiles[1][0].setValue(4); tiles[1][1].setValue(0);

        gameBoard.setTiles(tiles);

        boolean result = BoardLogic.canMoveSomewhere(gameBoard);

        assertTrue(result);
    }
}
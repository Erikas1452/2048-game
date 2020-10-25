import java.util.ArrayList;



public class GameLogic {

    public static void generateRandomTile(Board gameBoard)
    {
        gameBoard.findEmptyTiles();
        ArrayList<Integer> possibleValues = new ArrayList<Integer>();
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(2);
        possibleValues.add(4);

        ArrayList<Tile> emptyTiles = gameBoard.getEmptyTiles();

        int randomIndex = (int) (Math.random() * emptyTiles.size());
        int randomNumber = (int) (Math.random() * possibleValues.size());

        gameBoard.getEmptyTiles().get(randomIndex).setValue(possibleValues.get(randomNumber));

    }

    public static void moveTiles(Board gameBoard, char direction)
    {
        Tile allTiles [][] = gameBoard.getTiles();
        Tile original [][] = new Tile[4][4];

        for(int i = 0; i < gameBoard.getSize(); i++)
        {
            for(int j = 0; j < gameBoard.getSize(); j++)
            {
                original[i][j] = new Tile(allTiles[i][j].getValue());
            }
        }

        switch (direction) {
            case 'A':
                for (int i = 0; i < gameBoard.getSize(); i++) {
                    moveLeft(i, gameBoard.getSize(), allTiles);
                }
                break;
            case 'W':
                for (int i = 0; i < gameBoard.getSize(); i++) {
                    moveUP(i, gameBoard.getSize(), allTiles);
                }
                break;
            case 'S':
                for (int i = 0; i < gameBoard.getSize(); i++) {
                    moveDown(i, gameBoard.getSize(), allTiles);
                }
                break;
            case 'D':
                for (int i = 0; i < gameBoard.getSize(); i++) {
                    moveRight(i, gameBoard.getSize(), allTiles);
                    ;
                }
                break;
        }

        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                System.out.print(allTiles[i][j].getValue());
            }
            System.out.println();
        }

        if(isChanged(original,allTiles, gameBoard.getSize()))
        {
            gameBoard.setTiles(allTiles);
            generateRandomTile(gameBoard);
        }
        else
        {
            gameBoard.setTiles(original);
            System.out.println("Can't Move anything this direction");
        }

    }

    private static boolean isChanged(Tile original[][], Tile newBoard[][], int size)
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

    private static void moveUP(int column, int size, Tile tiles[][])
    {

        for(int i = 0; i < size; i++)
        {
            for(int k = i; k >= 0; k--)
            {
                if(k-1 != -1 && (tiles[k-1][column].getValue() == 0))
                {
                    System.out.println(tiles[k][column].getValue());
                    tiles[k-1][column].setValue(tiles[k][column].getValue());
                    tiles[k][column].setValue(0);
                }
                else if (k-1 != -1 && tiles[k-1][column].getValue() == tiles[k][column].getValue())
                {
                    System.out.println(tiles[k][column].getValue());
                    tiles[k-1][column].multiplyValue(2);
                    tiles[k][column].setValue(0);

                    break;
                }
                else break;
            }
        }
    }

    private static void moveDown(int column, int size, Tile tiles[][])
    {

        for(int i = size-1; i >= 0; i--)
        {
            for(int k = i; k < size; k++)
            {
                if(k+1 != size && (tiles[k+1][column].getValue() == 0))
                {
                    tiles[k+1][column].setValue(tiles[k][column].getValue());
                    tiles[k][column].setValue(0);
                }
                else if (k+1 != size && tiles[k+1][column].getValue() == tiles[k][column].getValue())
                {
                    tiles[k+1][column].multiplyValue(2);
                    tiles[k][column].setValue(0);

                    break;
                }
                else break;
            }
        }
    }

    private static void moveLeft(int row, int size, Tile tiles[][])
    {

        for(int j = 0; j < size; j++)
        {
            for(int k = j; k >= 0; k--)
            {
                if(k-1 != -1 && (tiles[row][k-1].getValue() == 0))
                {
                    tiles[row][k-1].setValue(tiles[row][k].getValue());
                    tiles[row][k].setValue(0);
                }
                else if (k-1 != -1 && tiles[row][k-1].getValue() == tiles[row][k].getValue())
                {
                    tiles[row][k-1].multiplyValue(2);
                    tiles[row][k].setValue(0);

                    break;
                }
                else break;
            }
        }
    }

    private static void moveRight(int row, int size, Tile tiles[][])
    {

        for(int j = size-1; j >= 0; j--)
        {
            for(int k = j; k < size; k++)
            {
                if(k+1 != size && (tiles[row][k+1].getValue() == 0))
                {
                    tiles[row][k+1].setValue(tiles[row][k].getValue());
                    tiles[row][k].setValue(0);
                }
                else if (k+1 != size && tiles[row][k+1].getValue() == tiles[row][k].getValue())
                {
                    tiles[row][k+1].multiplyValue(2);
                    tiles[row][k].setValue(0);
                    break;
                }
                else break;
            }
        }
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
        Tile allTiles [][] = gameBoard.getTiles();
        Tile original [][] = new Tile[4][4];

        for(int i = 0; i < gameBoard.getSize(); i++)
        {
            for(int j = 0; j < gameBoard.getSize(); j++)
            {
                original[i][j] = new Tile(allTiles[i][j].getValue());
            }
        }

        for (int i = 0; i < gameBoard.getSize(); i++) {
            moveLeft(i, gameBoard.getSize(), original);
        }

        if(isChanged(original,allTiles, gameBoard.getSize())) return true;

        for (int i = 0; i < gameBoard.getSize(); i++) {
            moveUP(i, gameBoard.getSize(), original);
        }

        if(isChanged(original,allTiles, gameBoard.getSize())) return true;

        for (int i = 0; i < gameBoard.getSize(); i++) {
            moveDown(i, gameBoard.getSize(), original);
        }

        if(isChanged(original,allTiles, gameBoard.getSize())) return true;

        for (int i = 0; i < gameBoard.getSize(); i++) {
            moveRight(i, gameBoard.getSize(), original);
        }

        if(isChanged(original,allTiles, gameBoard.getSize())) return true;

        return false;

    }

//    private static int getLine(Tile tiles[][], int i, int j, int size)
//    {
//
//    }
//
//    private static boolean canMove(Tile tiles[][], int direction, int i, int j, int size)
//    {
//
//    }

}

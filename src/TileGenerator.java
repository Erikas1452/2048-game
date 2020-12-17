import java.util.ArrayList;

public class TileGenerator {


    public static Tile generateNewTile()
    {
        ArrayList<Integer> possibleValues = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++) possibleValues.add(2);
        possibleValues.add(4);

        int randomNumber = (int) (Math.random() * possibleValues.size());

        Tile newTile = new Tile(possibleValues.get(randomNumber));

        return newTile;
    }

    public static int generateLocation(ArrayList<Tile> emptyTiles)
    {
        int randomIndex = (int) (Math.random() * emptyTiles.size());
        return randomIndex;
    }

}

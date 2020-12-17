import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private int size;
    private ArrayList<Tile> emptyTiles;
    private Tile tiles[][];


    public int getSize() {
        return size;
    }

    public Board(int size) {
        this.size = size;
        tiles = new Tile[size][size];
        setupTiles();
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public ArrayList<Tile> getEmptyTiles() {
        return emptyTiles;
    }

    public void findEmptyTiles()
    {
        this.emptyTiles = new ArrayList<Tile>();

        for(int i = 0; i < this.size; i++)
        {
            for(int j = 0; j < this.size; j++)
            {
                if(this.tiles[i][j].getValue() == 0)
                {
                    this.emptyTiles.add(this.tiles[i][j]);
                }
            }
        }
    }

    private void setupTiles()
    {
        for(int i = 0; i < this.size; i++)
        {
            for(int j = 0; j < this.size; j++)
            {
//               if((i == 0 && j == 0) || (i == 2 && j == 2))this.tiles[i][j] = new Tile(1024);
//               else this.tiles[i][j] = new Tile(0);

                this.tiles[i][j] = new Tile(0);

            }
        }
    }

    public void displayMap()
    {
        for(int i = 0; i < this.size; i++)
        {
            for(int j = 0; j < this.size; j++)
            {
                tiles[i][j].displayTile();
            }
            System.out.print("\n");
        }

        System.out.print("\n");
    }

    public Board copyBoard()
    {
        Tile originalTiles [][] = this.getTiles();
        Tile copyTiles [][] = new Tile[this.getSize()][this.getSize()];

        for(int i = 0; i < this.getSize(); i++)
        {
            for(int j = 0; j < this.getSize(); j++)
            {
                copyTiles[i][j] = new Tile(originalTiles[i][j].getValue());
            }
        }

        Board copy = new Board(this.getSize());
        copy.setTiles(copyTiles);

        return copy;
    }

}

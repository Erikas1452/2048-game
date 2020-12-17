import com.sun.org.glassfish.external.statistics.annotations.Reset;

public class Tile extends DefaultTile{

    public Tile(int value) {
        super(value);
    }

    public void merge(Tile tile)
    {
        this.multiplyValue(2);
        tile.setValue(0);
    }

    @Override
    public void displayTile()
    {
        System.out.format("[%-4d]",this.getValue());
    }
}

public class Tile {

    private int value;

    public Tile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void multiplyValue(int multiplyer)
    {
        this.value *= multiplyer;
    }

    public void merge(Tile tile)
    {
        this.multiplyValue(2);
        tile.setValue(0);
    }

    public boolean tilesAreEquel(Tile tile)
    {
        if (tile.getValue() == this.value) return true;
        else return false;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void displayTile()
    {
        System.out.format("[%-4d]",value);
    }
}

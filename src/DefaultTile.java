public class DefaultTile {
    private int value;

    public DefaultTile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void multiplyValue(int multiplyer)
    {
        this.value *= multiplyer;
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
        System.out.println(value);
    }
}

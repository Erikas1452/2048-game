public class Tile {

    private int value;
    private boolean mergable;

    public Tile(int value) {
        this.value = value;
        mergable = true;
    }

    public int getValue() {
        return value;
    }

    public void multiplyValue(int multiplyer)
    {
        this.value *= multiplyer;
    }

    public void enableMerging()
    {
        this.mergable = true;
    }

    public void dissableMerging()
    {
        this.mergable = false;
    }

    public boolean isMergable() {
        return mergable;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void displayTile()
    {
        System.out.format("[%-4d]",value);
    }
}

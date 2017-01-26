package object_programming_2.snow.ui.model;

public class RGBImage {

    private final short[][] red;
    private final short[][] green;
    private final short[][] blue;
    private final Dimension dimension;

    public RGBImage(short[][] red, short[][] green, short[][] blue, Dimension dimension) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.dimension = dimension;
    }

    public short[][] getRed() {
        return red;
    }

    public short[][] getGreen() {
        return green;
    }

    public short[][] getBlue() {
        return blue;
    }

    public Dimension getDimension() {
        return dimension;
    }
}

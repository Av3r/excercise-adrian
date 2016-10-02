package object_programming.lab3.florist_simple.flowers;

import object_programming.lab3.florist_simple.PriceList;

public class Freesia extends Flower {

    private static final String COLOR = "żółty";
    private static final String NAME = "frezja";

    public Freesia(int count) {
        super(count, COLOR, NAME);
    }

    public String toString() {
        PriceList pl = PriceList.getInstance();
        return String.format("%s, kolor: %s, ilość %d, cena %.1f",
                getName(), getColor(), getCount(), pl.getPrice(getName()));
    }
}
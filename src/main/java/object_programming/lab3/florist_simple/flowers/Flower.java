package object_programming.lab3.florist_simple.flowers;

public abstract class Flower {

    private int count;
    private String color;
    private String name;

    public Flower(int count, String color, String name) {
        this.count = count;
        this.color = color;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}

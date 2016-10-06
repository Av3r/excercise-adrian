package object_programming_2.lab1.country_table.ui.model;

public class Country {

    private String name;
    private String capital;
    private int population;
    private String imagePath;

    public Country(String name, String capital, int population, String imagePath) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public String getImagePath() {
        return imagePath;
    }
}

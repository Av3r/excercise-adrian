package object_programming.lab3.pacjenci;

public abstract class Pacjent {
    private String name;

    public Pacjent(String name) {
        this.name = name;
    }

    public String nazwisko(){
        return name;
    }

    public abstract String choroba();

    public abstract String leczenie();
}

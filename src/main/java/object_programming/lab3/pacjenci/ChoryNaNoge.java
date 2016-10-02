package object_programming.lab3.pacjenci;

public class ChoryNaNoge extends Pacjent {

    public ChoryNaNoge(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "noga";
    }

    @Override
    public String leczenie() {
        return "gips";
    }

}

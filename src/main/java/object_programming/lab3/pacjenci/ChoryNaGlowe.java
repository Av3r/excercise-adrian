package object_programming.lab3.pacjenci;

public class ChoryNaGlowe extends Pacjent {

    public ChoryNaGlowe(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "głowa";
    }

    @Override
    public String leczenie() {
        return "aspiryna";
    }

}

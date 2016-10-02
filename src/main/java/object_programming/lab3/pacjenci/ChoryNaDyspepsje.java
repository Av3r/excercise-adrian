package object_programming.lab3.pacjenci;

public class ChoryNaDyspepsje extends Pacjent {

    public ChoryNaDyspepsje(String name) {
        super(name);
    }

    @Override
    public String choroba() {
        return "dyspensja";
    }

    @Override
    public String leczenie() {
        return "węgiel";
    }

}

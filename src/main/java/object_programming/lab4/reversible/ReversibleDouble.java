package object_programming.lab4.reversible;

public class ReversibleDouble implements Reversible {

    private double number;

    public ReversibleDouble(double number){
        this.number=number;
    }

    @Override
    public void reverse() {
        this.number= Math.pow(number, -1);
    }

    @Override
    public void changeValue() {
        this.number += 10;
    }

    public String toString(){
        return String.valueOf(number);
    }
}

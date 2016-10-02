package object_programming.lab4.reversible;

public class ReversibleString implements Reversible {

    private String text;

    public ReversibleString(String text){
        this.text = text;
    }

    @Override
    public void reverse() {
        String reversed= "";
        for (int i = text.length()-1; i >=0 ; i--) {
            reversed+= text.charAt(i);
        }
        this.text = reversed;
    }

    @Override
    public void changeValue() {
        this.text = "Tekst " + text;
    }

    public String toString(){
        return text;
    }

}

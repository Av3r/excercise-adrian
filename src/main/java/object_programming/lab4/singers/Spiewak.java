package object_programming.lab4.singers;

public abstract class Spiewak {
    private static int counter=1;
    private String name;
    private int id;

    Spiewak(String name) {
        this.name = name;
        this.id = counter;
        counter++;
    }

    public abstract String spiewaj();

    public static Spiewak najglosniej(Spiewak[] spiewajacy){
        Spiewak max = spiewajacy[0];
        for (int i = 0; i < spiewajacy.length; i++) {
            if(countUpperCases(spiewajacy[i].spiewaj()) > countUpperCases(max.spiewaj())){
                max = spiewajacy[i];
            }
        }
        return max;
    }

    private static int countUpperCases(String text){
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if(Character.isUpperCase(character)){
                sum++;
            }
        }
        return sum;
    }

    public String toString() {
        return String.format("(%d) %s: %s", id, name, spiewaj());
    }
}

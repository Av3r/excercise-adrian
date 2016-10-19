package object_programming.other.courses;

import java.util.ArrayList;
import java.util.List;

public class Kurs {

    private String name;
    private int minAgeLimit;
    private int maxPeopleLimit;
    private List<Osoba> osoby = new ArrayList<>();

    public Kurs(String name, int minAgeLimit, int maxPeopleLimit) {
        this.name = name;
        this.minAgeLimit = minAgeLimit;
        this.maxPeopleLimit = maxPeopleLimit;
    }

    public Kurs dodajUczestnika(Osoba osoba) {
        if (osoba == null) {
            System.out.println("Nie podano uczestnika przy zapisywaniu");
        } else if (osoby.contains(osoba)) {
            System.out.printf("%s jest juz zapisana/y do kursu %s\n", osoba.getName(), name);
        } else if (osoby.size() >= maxPeopleLimit) {
            System.out.printf("Kurs %s: brak miejsc!\n", name);
        } else if (osoba.getAge() < minAgeLimit) {
            System.out.printf("%s nie spiełnia kryterium wiekowego do kursu %s\n", osoba.getName(), name);
        } else {
            this.osoby.add(osoba);
            System.out.printf("Dodano uczestnika %s do kursu %s\n", osoba.getName(), name);
        }
        return this;
    }

    public void usunUczestnika(Osoba osoba) {
        if (osoba == null) {
            System.out.println("Nie podano uczestnika przy usunieciu");
        } else if (!osoby.contains(osoba)) {
            System.out.printf("Kurs %s nie ma uczestnika %s\n", name, osoba.getName());
        } else {
            osoby.remove(osoba);
            System.out.printf("Usunieto uczestnika %s z kursu %s\n", osoba.getName(), name);
        }
    }

    public String getNazwaKursu() {
        return name;
    }

    public int getNumberOfPeople() {
        return osoby.size();
    }

    public String toString() {
        return String.format("Kurs %s, uczestniczy: %s", name, osoby);
    }
}

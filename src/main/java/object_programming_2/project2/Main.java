package object_programming_2.project2;

import java.text.ParseException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws ParseException {
        int daysToSubtract = 2673;

        printPastDatesFromZones(daysToSubtract);
        printDatesInDifferentCalendars();
        convertDates();
    }

    private static void printPastDatesFromZones(int daysToSubtract) {
        printDates(daysToSubtract, "Petersburg", "Europe/Moscow");
        printDates(daysToSubtract, "Rome", "Europe/Berlin");
        printDates(daysToSubtract, "Istanbul", "Europe/Istanbul");
    }

    private static void printDates(int daysToSubtract, String city, String zone) {
        String dayOfWeek = Kalendarz.getDayOfWeekFromPast(daysToSubtract, zone);
        String month = Kalendarz.getMonthFromPast(daysToSubtract, zone);
        int year = Kalendarz.getYearFromPast(daysToSubtract, zone);

        System.out.printf("%d days ago in city [%s] and zone [%s] was:\n", daysToSubtract, city, zone);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("month = " + month);
        System.out.println(year);
        System.out.println("***************************");
    }

    private static void printDatesInDifferentCalendars() {
        System.out.println("Today is:");
        printJulianDate(LocalDate.now());
        printGregorianDate(LocalDate.now());
    }

    private static void printJulianDate(LocalDate date) {
        String julianDate = Kalendarz.getJulianDate(date);
        System.out.println("julianDate = " + julianDate);
    }

    private static void printGregorianDate(LocalDate date) {
        String gregorianDate = Kalendarz.getGregorianDate(date);
        System.out.println("gregorianDate = " + gregorianDate);
    }

    private static void convertDates() throws ParseException {
        System.out.println("***************************");
        String julianDate = "2009218";
        String date = Kalendarz.convertFromJulianDate(julianDate);
        System.out.printf("Julian date [%s] converted to gregorian: [%s]", julianDate, date);
    }

}

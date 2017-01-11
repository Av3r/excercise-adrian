package object_programming_2.project2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class Kalendarz {

    private static final String JULIAN_DATE_PATTERN = "yyyyD";
    private static final String DATE_PATTERN = "dd MM yyyy";
    private static final String GREGORIAN_PATTERN = "dd LLLL yyyy";
    private static final String EMPTY_STRING = "";

    static String getDayOfWeekFromPast(int subtractDays, String zone) {
        LocalDate localDate = createDate(subtractDays, zone);
        return localDate.getDayOfWeek().toString();
    }

    static String getMonthFromPast(int subtractDays, String zone) {
        LocalDate localDate = createDate(subtractDays, zone);
        return localDate.getMonth().toString();
    }

    static int getYearFromPast(int subtractDays, String zone) {
        LocalDate localDate = createDate(subtractDays, zone);
        return localDate.getYear();
    }

    static String getJulianDate(LocalDate date) {
        return date.getYear() + EMPTY_STRING + date.getDayOfYear();
    }

    static String getGregorianDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GREGORIAN_PATTERN);
        return formatter.format(date);
    }

    static String convertFromJulianDate(String julianDate) throws ParseException {
        Date myDate = new SimpleDateFormat(JULIAN_DATE_PATTERN).parse(julianDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        return dateFormat.format(myDate);
    }

    private static LocalDate createDate(int subtractDays, String zone) {
        ZoneId zoneId = ZoneId.of(zone);
        return LocalDate.now(zoneId).minusDays(subtractDays);
    }

}

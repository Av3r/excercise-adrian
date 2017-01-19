package object_programming_2.lab10.parser;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CurrencyParser {


    public static String parseFromPolishToEnglishPrice(String price) throws ParseException {
        Double priceDecimal = new Double(price.replace(",", "."));
        Locale englishLocale = buildLocale("en", "GB");
        NumberFormat formatter = NumberFormat.getInstance(englishLocale);
        return formatter.format(priceDecimal);
    }

    public static String parseFromEnglishToPolishPrice(String price) throws ParseException {
        Double priceDecimal = new Double(price.replace(",", ""));
        Locale englishLocale = buildLocale("pl", "PL");
        NumberFormat formatter = NumberFormat.getInstance(englishLocale);
        return formatter.format(priceDecimal);
    }

    public static String parseToPolishPrice(String price) {
        Double priceDecimal = new Double(price.replace(",", "."));
        Locale englishLocale = buildLocale("pl", "PL");
        NumberFormat formatter = NumberFormat.getInstance(englishLocale);
        return formatter.format(priceDecimal);
    }

    private static Locale buildLocale(String language, String region) {
        return new Locale.Builder()
                .setLanguage(language)
                .setRegion(region)
                .build();
    }
}

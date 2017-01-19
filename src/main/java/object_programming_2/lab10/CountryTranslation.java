package object_programming_2.lab10;

import java.util.Arrays;

public enum CountryTranslation {
    JAPAN("Japonia", "Japan"),
    ITALY("Włochy", "Italy"),
    UNITED_STATES("Stany Zjednoczone Ameryki", "United States");

    private String polishLabel;
    private String englishLabel;

    CountryTranslation(String polishLabel, String englishLabel) {
        this.polishLabel = polishLabel;
        this.englishLabel = englishLabel;
    }

    public static String traslateToEnglish(String polishLabel) {
        return Arrays.stream(CountryTranslation.values())
                .filter(element -> element.getPolishLabel().equals(polishLabel))
                .map(CountryTranslation::getEnglishLabel)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There was no element with polish label: " + polishLabel));
    }

    public static String translateToPolish(String englishLabel) {
        return Arrays.stream(CountryTranslation.values())
                .filter(element -> element.getEnglishLabel().equals(englishLabel))
                .map(CountryTranslation::getPolishLabel)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There was no element with english label: " + englishLabel));
    }

    public String getPolishLabel() {
        return polishLabel;
    }

    public String getEnglishLabel() {
        return englishLabel;
    }
}

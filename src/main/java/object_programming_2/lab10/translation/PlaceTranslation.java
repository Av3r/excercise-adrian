package object_programming_2.lab10.translation;

import java.util.Arrays;

public enum PlaceTranslation {
    LAKE("jezioro", "lake"),
    SEA("morze", "sea"),
    MOUNTAINS("góry", "mountains");

    private String polishLabel;
    private String englishLabel;

    PlaceTranslation(String polishLabel, String englishLabel) {
        this.polishLabel = polishLabel;
        this.englishLabel = englishLabel;
    }

    public static String translateToEnglish(String polishLabel) {
        return Arrays.stream(PlaceTranslation.values())
                .filter(element -> element.getPolishLabel().equals(polishLabel))
                .map(PlaceTranslation::getEnglishLabel)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There was no element with polish label: " + polishLabel));
    }

    public static String translateToPolish(String englishLabel) {
        return Arrays.stream(PlaceTranslation.values())
                .filter(element -> element.getEnglishLabel().equals(englishLabel))
                .map(PlaceTranslation::getPolishLabel)
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

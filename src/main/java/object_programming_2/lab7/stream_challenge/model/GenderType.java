package object_programming_2.lab7.stream_challenge.model;

import java.util.Arrays;

public enum GenderType {

    FEMALE("f"),
    MALE("m");

    private String genderLetter;

    GenderType(String genderLetter) {
        this.genderLetter = genderLetter;
    }

    public static GenderType fromLetter(String letter) {
        return Arrays.stream(values())
                .filter(genderType -> genderType.genderLetter.equals(letter))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No suitable GenderType for letter: " + letter));
    }
}

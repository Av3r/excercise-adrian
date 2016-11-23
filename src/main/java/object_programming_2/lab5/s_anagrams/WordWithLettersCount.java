package object_programming_2.lab5.s_anagrams;

import java.util.Map;

public class WordWithLettersCount {

    private String word;
    private Map<Character, Integer> lettersCount;

    public WordWithLettersCount(String word, Map<Character, Integer> lettersCount) {
        this.word = word;
        this.lettersCount = lettersCount;
    }

    public String getWord() {
        return word;
    }

    public Map<Character, Integer> getLettersCount() {
        return lettersCount;
    }

    @Override
    public String toString() {
        return "WordWithLettersCount{" +
                "word='" + word + '\'' +
                ", lettersCount=" + lettersCount +
                '}';
    }
}

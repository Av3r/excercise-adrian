package object_programming_2.lab5.s_anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    private String filePath;
    private List<String> words;

    public Anagrams(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.words = new ArrayList<>();
        initializeWordList();
    }

    private void initializeWordList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
    }

    public List<List<String>> getSortedByAnQty() {
        List<WordWithLettersCount> wordWithLettersCounts = words.stream()
                .map(this::getWordWithLettersCount)
                .collect(Collectors.toList());

        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
        for (WordWithLettersCount wordWithLettersCount : wordWithLettersCounts) {
            List<String> anagramsList = anagrams.getOrDefault(wordWithLettersCount.getLettersCount(), new ArrayList<>());
            anagramsList.add(wordWithLettersCount.getWord());
            anagrams.put(wordWithLettersCount.getLettersCount(),anagramsList);
        }

        return anagrams.values().stream()
                .sorted(Comparator.comparing(List::size))
                .collect(Collectors.toList());
    }

    public String getAnagramsFor(String wordToFind) {
        List<String> anagrams = null;

        if(words.contains(wordToFind)) {
            anagrams = words.stream()
                    .filter(word -> !word.equals(wordToFind))
                    .filter(word -> isAnagram(word, wordToFind))
                    .collect(Collectors.toList());
        }

        return String.format("%s: %s", wordToFind, anagrams);
    }

    private boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> word1LettersCount = getLettersCountFromWord(word1);
        Map<Character, Integer> word2LettersCount = getLettersCountFromWord(word2);

        return word1LettersCount.equals(word2LettersCount);
    }

    private Map<Character, Integer> getLettersCountFromWord(String word) {
        Map<Character, Integer> wordLettersCount = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char word1Char = word.charAt(i);
            Integer word1CharCount = wordLettersCount.getOrDefault(word1Char, 0);
            wordLettersCount.put(word1Char, ++word1CharCount);
        }
        return wordLettersCount;
    }

    private WordWithLettersCount getWordWithLettersCount(String word) {
        return new WordWithLettersCount(word,getLettersCountFromWord(word));
    }

}

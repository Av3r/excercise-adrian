package object_programming_2.lab6.s_anagramstream;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class AnagramFinder {

    private String url;
    private List<String> words;

    public AnagramFinder(String url) throws Exception {
        this.url = url;
        this.words = new ArrayList<>();
        initializeWordList();
    }

    public List<List<String>> findAnagrams() {
        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();

        words.stream()
                .map(this::getWordWithLettersCountFromWord)
                .forEach(wordWithCounter -> addCounterToAnagramMap(anagrams, wordWithCounter));

        return anagrams.values().stream()
                .filter(words -> words.size() > 1)
                .sorted(getListComparator())
                .collect(Collectors.toList());
    }

    private void initializeWordList() throws Exception {
        URL url = new URL(this.url);
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
    }

    private Comparator<List<String>> getListComparator() {
        return (o1, o2) -> {
            Integer o1Size = o1.size();
            Integer o2Size = o2.size();
            return o2Size.compareTo(o1Size);
        };
    }

    private void addCounterToAnagramMap(Map<Map<Character, Integer>, List<String>> anagrams, WordWithLettersCount wordWithCounter) {
        Map<Character, Integer> counter = wordWithCounter.getLettersCount();
        String word = wordWithCounter.getWord();

        List<String> anagramList = anagrams.getOrDefault(counter, new ArrayList<>());
        anagramList.add(word);
        anagrams.put(counter, anagramList);
    }

    private WordWithLettersCount getWordWithLettersCountFromWord(String word) {
        return new WordWithLettersCount(word, getLettersCountFromWord(word));
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

}

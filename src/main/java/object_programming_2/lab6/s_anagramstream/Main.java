package object_programming_2.lab6.s_anagramstream;

import java.util.List;


public class Main {

    private static final String SPACE = " ";

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        String url = "http://www.puzzlers.org/pub/wordlists/unixdict.txt";
        AnagramFinder anagramFinder = new AnagramFinder(url);
        List<List<String>> anagrams = anagramFinder.findAnagrams();
        anagrams.forEach(Main::printWords);

        long end = System.currentTimeMillis();
        long elapsedInMs = end - start;
        System.out.println(String.format("Execution took %d ms", elapsedInMs));
    }

    private static void printWords(List<String> words) {
        words.forEach(word -> System.out.print(word + SPACE));
        System.out.println();
    }
}

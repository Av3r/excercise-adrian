package object_programming.lab2.words;

import java.io.File;
import java.util.*;

public class CountWords {

    private String filePath;

    public CountWords(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getResult() throws Exception {
        List<String> words = new ArrayList<>();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        return returnWordsAndCounts(words);
    }

    private List<String> returnWordsAndCounts(List<String> words) {
        List<String> wordsAndCountList= new ArrayList<>();
        Map<String, Integer> wordsAndCount = countWords(words);

        for (Map.Entry<String, Integer> wordAndCountEntry : wordsAndCount.entrySet()) {
            wordsAndCountList.add(wordAndCountEntry.getKey()+ " " + wordAndCountEntry.getValue());
        }

        return wordsAndCountList;
    }

    private Map<String, Integer> countWords(List<String> words){
        Map<String, Integer> wordsAndCount = new HashMap<>();
        for (String word : words) {
            if(wordsAndCount.containsKey(word)){
                wordsAndCount.put(word, wordsAndCount.get(word) + 1 );
            } else{
                wordsAndCount.put(word, 1);
            }
        }
        return wordsAndCount;
    }

}



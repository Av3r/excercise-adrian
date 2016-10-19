package object_programming_2.lab4.lamcomb;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;


public class Main {

    public static void main(String[] args) {
        //TODO do zrobienia
    /*<--
     *  definicja operacji w postaci lambda-wyrażeń:
     *  - flines - zwraca listę wierszy z pliku tekstowego
     *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
     *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
     *  - sum - zwraca sumę elmentów listy liczb całkowitych
     */
        Function<String,List<String>> flines = s -> Lists.newArrayList("text", "text2");
        Function<List<String>, String> join = null;
        Function<String, List<Integer>> collectInts = null;
        Function<List<Integer>, Integer> sum = null;

        String fname = System.getProperty("user.home") + "/LamComFile.txt";
        InputConverter<String> fileConv = new InputConverter<>(fname);
        List<String> lines = fileConv.convertBy(flines);
//        String text = fileConv.convertBy(flines, join);
//        List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
//        Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);
//
        System.out.println(lines);
//        System.out.println(text);
//        System.out.println(ints);
//        System.out.println(sumints);
//
//        List<String> arglist = Arrays.asList(args);
//        InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
//        sumints = slistConv.convertBy(join, collectInts, sum);
//        System.out.println(sumints);
    }
}

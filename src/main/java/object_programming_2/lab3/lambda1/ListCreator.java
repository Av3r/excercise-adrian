package object_programming_2.lab3.lambda1;

import java.util.List;
import java.util.stream.Collectors;

public class ListCreator {

    private List<String> elements;

    public ListCreator(List<String> elements) {
        this.elements = elements;
    }

    public static ListCreator collectFrom(List<String> list) {
        return new ListCreator(list);
    }

    public ListCreator when(Selector<String> sel) {
        List<String> filteredList = elements.stream()
                .filter(sel::select)
                .collect(Collectors.toList());
        return new ListCreator(filteredList);
    }

    public List<String> mapEvery(Mapper<String> mapper) {
        return elements.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}

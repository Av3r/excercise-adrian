package object_programming_2.lab2.generics;

import java.util.List;
import java.util.stream.Collectors;

public class ListCreator<T> {

    private List<T> elements;

    public ListCreator(List<T> elements) {
        this.elements = elements;
    }

    public static <T> ListCreator collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Selector<T> sel) {
        List<T> filteredList = elements.stream()
                .filter(sel::select)
                .collect(Collectors.toList());
        return new ListCreator<>(filteredList);
    }

    public List<Integer> mapEvery(Mapper<T> mapper) {
        return elements.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}

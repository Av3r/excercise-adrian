package object_programming_2.lab4.lamcomb;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputConverter<S> {

    private String fileName;

    public InputConverter(String fileName) {
        this.fileName = fileName;
    }

    public List<String> convertBy(Function<String, List<String>>... converters){
        return Arrays.stream(converters)
                .map(function -> function.apply(fileName))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}

package object_programming_2.lab4.lamcomb;

import java.util.function.Function;

public class InputConverter<T> {

    private T value;

    public InputConverter(T value) {
        this.value = value;
    }

    public <R> R convertBy(Function... functions) {
        Object result = value;
        for (Function function : functions) {
            result = function.apply(result);
        }
        return (R) result;
    }
}

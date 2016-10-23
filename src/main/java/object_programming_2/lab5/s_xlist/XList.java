package object_programming_2.lab5.s_xlist;

import com.google.common.base.Ascii;
import com.google.common.base.Splitter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class XList<T> {

    private static final String DEFAULT_DELIMITER = " ";

    private List<T> vals;

    public XList(T... vals) {
        this.vals = Arrays.asList(vals);
    }

    public XList(Collection<T> vals) {
        this.vals = vals.stream()
                .collect(Collectors.toList());
    }

    public static<B> XList<B> of(B... vals) {
        return new XList<>(vals);
    }

    public static<B> XList<B> of(Set<B> vals) {
        return new XList<>(vals);
    }

    public static XList<String> charsOf(String text) {
        List<String> chars = text.chars()
                .mapToObj(value -> (char) value)
                .map(String::valueOf)
                .collect(Collectors.toList());

        return new XList<>(chars);
    }

    public static XList<String> tokensOf(String text) {
        return tokensOf(text, DEFAULT_DELIMITER);
    }

    public static XList<String> tokensOf(String text, String delimiter) {
        List<String> tokens = Splitter.on(delimiter).splitToList(text);
        return new XList<>(tokens);
    }

    @Override
    public String toString() {
        return vals.toString();
    }
}

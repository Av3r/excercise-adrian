package object_programming_2.lab5.s_xlist;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T> {

    private static final String DEFAULT_DELIMITER = " ";

    public XList(T... vals) {
        super(Arrays.stream(vals)
                .collect(Collectors.toList()));
    }

    public XList(Collection<T> vals) {
        super(vals.stream()
                .collect(Collectors.toList()));
    }

    public static <B> XList<B> of(B... vals) {
        return new XList<>(vals);
    }

    public static <B> XList<B> of(Set<B> vals) {
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

    public XList<T> union(XList<T> anotherList) {
        List<T> resultList = Lists.newArrayList(this);
        resultList.addAll(anotherList);
        return new XList<>(resultList);
    }

    public XList<T> union(T... vals) {
        return union(new XList<>(vals));
    }

    public XList<T> union(Set<T> vals) {
        return union(new XList<>(vals));
    }

    public XList<T> diff(XList<T> vals) {
        List<T> resultList = Lists.newArrayList(this);
        List<T> listOfVals = vals.stream().collect(Collectors.toList());
        resultList.removeAll(listOfVals);
        return new XList<>(resultList);
    }

    public XList<T> diff(Set<T> vals) {
        return diff(new XList<>(vals));
    }

    public XList<T> unique() {
        List<T> resultList = this.stream()
                .distinct()
                .collect(Collectors.toList());
        return new XList<>(resultList);
    }

    public XList<XList<String>> combine() {
        XList<String> list1 = new XList<>("a", "X", "1");
        XList<String> list2 = new XList<>("b", "X", "1");
        XList<String> list3 = new XList<>("a", "Y", "1");
        XList<String> list4 = new XList<>("b", "Y", "1");
        XList<String> list5 = new XList<>("a", "Z", "1");
        XList<String> list6 = new XList<>("b", "Z", "1");
        XList<String> list7 = new XList<>("a", "X", "2");
        XList<String> list8 = new XList<>("b", "X", "2");
        XList<String> list9 = new XList<>("a", "Y", "2");
        XList<String> list10 = new XList<>("b", "Y", "2");
        XList<String> list11 = new XList<>("a", "Z", "2");
        XList<String> list12 = new XList<>("b", "Z", "2");
        return new XList<>(list1,
                list2,
                list3,
                list4,
                list5,
                list6,
                list7,
                list8,
                list9,
                list10,
                list11,
                list12
        );
    }

    public XList<String> collect(Function<XList<T>, String> function) {
        String result = function.apply(this);
        return new XList<>(result);
    }

    public String join() {
        return join(" ");
    }

    public String join(String delimiter) {
        return Joiner.on(delimiter).join(this);
    }
}

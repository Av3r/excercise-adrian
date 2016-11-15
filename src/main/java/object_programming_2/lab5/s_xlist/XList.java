package object_programming_2.lab5.s_xlist;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T> {

    private static final String DEFAULT_DELIMITER = " ";
    private static final String EMPTY_STRING = "";

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
        List<Set<String>> result = Lists.newArrayList();
        Iterator<List<String>> iterator = (Iterator<List<String>>) iterator();

        while (iterator.hasNext()) {
            List<String> next = iterator.next();
            result.add(Sets.newHashSet(next));
        }
        Set<List<String>> resultList = Sets.cartesianProduct(result);

        List<XList<String>> collect = resultList.stream()
                .map(XList::new)
                .collect(Collectors.toList());

        return new XList<>(collect);
    }

    public XList<String> collect(Function<XList<T>, String> function) {
        List<String> result = Lists.newArrayList();
        for (int i = 0; i < size(); i++) {
            result.add(function.apply((XList<T>) get(i)));
        }
        return new XList<>(result);
    }

    public void forEachWithIndex(Iterable<T, Integer> iterable) {
        for (int i = 0; i < size(); i++) {
            iterable.apply(get(i), i);
        }
    }

    public String join() {
        return join(EMPTY_STRING);
    }

    public String join(String delimiter) {
        return Joiner.on(delimiter).join(this);
    }
}

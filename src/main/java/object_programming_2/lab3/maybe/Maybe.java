package object_programming_2.lab3.maybe;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {

    private T t;

    public Maybe() {
    }

    public Maybe(T t) {
        this.t = t;
    }

    public static <T> Maybe<T> of(T t) {
        return new Maybe<>(t);
    }

    public void ifPresent(Consumer<T> cons) {
        if (t != null) {
            cons.accept(t);
        }
    }

    public <R> Maybe<R> map(Function<T, R> func) {
        if(t != null){
            R newValue = func.apply(t);
            return new Maybe<>(newValue);
        }else{
            return new Maybe<>();
        }
    }

    public T get() {
        if (t == null) {
            throw new NoSuchElementException(" maybe is empty");
        }
        return t;
    }

    public boolean isPresent() {
        return t != null;
    }

    public T orElse(T defVal) {
        if (t == null) {
            return defVal;
        }
        return t;
    }

    public Maybe<T> filter(Predicate<T> pred) {
        if (pred.test(t)) {
            return this;
        }
        return new Maybe<>();
    }

    public String toString() {
        if (t != null) {
            return String.format("Maybe has value %s", t);
        } else {
            return "Maybe is empty";
        }
    }
}

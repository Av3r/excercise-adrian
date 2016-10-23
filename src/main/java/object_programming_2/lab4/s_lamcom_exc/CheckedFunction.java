package object_programming_2.lab4.s_lamcom_exc;


import java.util.function.Function;

@FunctionalInterface
public interface CheckedFunction<T,R> extends Function <T,R>{

    @Override
    default R apply(T t){
        try {
            return applyWithException(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    R applyWithException(T t) throws Exception;

}

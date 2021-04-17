package lesson_ten.functionalInterface;

@FunctionalInterface
public interface FunctionInterface<T, U> {
    U convert(T t);
}

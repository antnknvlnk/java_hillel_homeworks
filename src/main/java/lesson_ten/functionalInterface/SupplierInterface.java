package lesson_ten.functionalInterface;

@FunctionalInterface
public interface SupplierInterface<T> {

    T get();
}

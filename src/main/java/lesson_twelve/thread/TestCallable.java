package lesson_twelve.thread;

import lesson_twelve.util.TestClass;

import java.util.concurrent.Callable;

public class TestCallable implements Callable {
    @Override
    public synchronized Object call() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Test Callable: ");
            TestClass.incrementNumber();
        }
        return TestClass.value;
    }
}

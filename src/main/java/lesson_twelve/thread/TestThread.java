package lesson_twelve.thread;

import lesson_twelve.util.TestClass;

public class TestThread extends Thread{
    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Test Thread: ");
            TestClass.incrementNumber();
        }
    }
}

package lesson_thirteen.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    Lock lock = new ReentrantLock();

    public void firstPrint(){
        lock.lock();
        for (int i = 0; i < 100; i++) {
            System.out.println("First Print Method " + Thread.currentThread().getName());
        }
    }

    public void increment(int value){
        for (int i = 0; i < 100; i++) {
            System.out.println(value++ + " " + Thread.currentThread().getName());
        }
    }

    public void lastPrint(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Last Print " + Thread.currentThread().getName());
        }
        lock.unlock();
    }
}

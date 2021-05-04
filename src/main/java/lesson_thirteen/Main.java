package lesson_thirteen;

import lesson_thirteen.lock.LockTest;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static LockTest lockTest = new LockTest();

    public static void main(String[] args) throws InterruptedException {

//        AtomicInteger value = new AtomicInteger(10000);
//
//        Object o1 = new Object();
//        for (int i = 0; i < 10000; i++) {
//            Thread thread = new Thread(() -> {
//                synchronized (o1) {
//                    value.getAndDecrement();
////                    System.out.println(value + " " + Thread.currentThread().getName());
//                    o1.notify();
//                }
//            });
//            thread.start();
//            synchronized (o1){
//                o1.wait();
//            }
//        }
//        Object o2 = new Object();
//        for (int i = 0; i < 10000; i++) {
//            Thread thread = new Thread(() -> {
//                synchronized (o2) {
//                    value.getAndDecrement();
////                    System.out.println(value + " " + Thread.currentThread().getName());
//                    o2.notify();
//                }
//            });
//            thread.start();
//            synchronized (o2){
//                o2.wait();
//            }
//        }
//
//        System.out.println("The result of value is: " + value);

        Thread thread1 = new Thread(new Runnable() {
            private LockTest testLock = lockTest;
            @Override
            public void run() {
                lockTest.firstPrint();
                lockTest.increment(0);
                lockTest.lastPrint();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            private LockTest testLock = lockTest;
            @Override
            public void run() {
                lockTest.firstPrint();
                lockTest.increment(0);
                lockTest.lastPrint();
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            private LockTest testLock = lockTest;
            @Override
            public void run() {
                lockTest.firstPrint();
                lockTest.increment(0);
                lockTest.lastPrint();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

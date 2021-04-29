package lesson_twelve;

import lesson_twelve.deadlock.Deadlock;
import lesson_twelve.thread.TestCallable;
import lesson_twelve.thread.TestRunnable;
import lesson_twelve.thread.TestThread;
import lesson_twelve.util.TestClass;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread testThread = new TestThread();
        testThread.start();
//        Thread.sleep(1000);

        TestRunnable testRunnable = new TestRunnable();
        Thread testRunnableThread = new Thread(testRunnable);
        testRunnableThread.start();
//        Thread.sleep(1000);


        TestCallable testCallable = new TestCallable();
        FutureTask<Integer> task= new FutureTask<>(testCallable);
        Thread testCallableThread = new Thread(task);
        testCallableThread.start();
//        Thread.sleep(1000);
        Integer testCallableString = task.get();
        System.out.println(testCallableString);

        TestClass.incrementNumber();

//        при обычном запуске 1 из 10 запусков показывает +-2988
//        синхронизированный бывало 2922
//        с тред слип всегда 3000

        new Deadlock();
    }
}

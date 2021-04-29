package lesson_twelve.deadlock;

import lombok.SneakyThrows;

public class Deadlock implements Runnable{
    FirstClass firstClass = new FirstClass();
    SecondClass secondClass = new SecondClass();

    public Deadlock() throws InterruptedException {
        Thread.currentThread().setName("Main Thread");
        Thread t = new Thread(this, "Rival Thread");
        t.start();

        firstClass.first(secondClass);

        System.out.println("Back to Main Thread");
    }

    @SneakyThrows
    @Override
    public void run() {
        secondClass.first(firstClass);
        System.out.println("Back to another Thread");
    }
}
